package com.example.mvi.ui.splash.viewmodel

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.example.core.data.usecase.GetAppStateUseCase
import com.example.mvi.ui.base.BaseViewModel
import com.example.mvi.ui.splash.SplashPartialChange
import com.example.mvi.ui.splash.SplashViewIntent
import com.example.mvi.ui.splash.SplashViewState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*

@FlowPreview
@ExperimentalCoroutinesApi
class SplashVM(
    application: Application,
    private val getAppStateUseCase: GetAppStateUseCase,
) : BaseViewModel(application) {

    private val _intentChannel = ConflatedBroadcastChannel<SplashViewIntent>()
    val viewStateChannel: StateFlow<SplashViewState>

    init {
        val initVS = SplashViewState.initial()
        viewStateChannel = MutableStateFlow(initVS)
        _intentChannel.asFlow()
            .distinctUntilChanged()
            .toPartialChange()
            .scan(initVS) { viewState, change -> change.reduce(viewState) }
            .onEach { viewState -> viewStateChannel.value = viewState }
            .launchIn(viewModelScope)
    }

    suspend fun processIntent(intent: SplashViewIntent) {
        _intentChannel.send(intent)
    }

    private fun Flow<SplashViewIntent>.toPartialChange(): Flow<SplashPartialChange> {
        val tutorialFlagFlow = getAppStateUseCase(Unit)
            .debounce(SPLASH_DURATION)
            .map { SplashPartialChange.GetAppState.Data(it.getOrThrow()) as SplashPartialChange.GetAppState }
            .onStart { emit(SplashPartialChange.GetAppState.Loading) }
            .catch { }

        return merge(
            filterIsInstance<SplashViewIntent.Initial>()
                .flatMapConcat { tutorialFlagFlow }
        )
    }

    companion object {
        const val SPLASH_DURATION = 2000L
    }


}