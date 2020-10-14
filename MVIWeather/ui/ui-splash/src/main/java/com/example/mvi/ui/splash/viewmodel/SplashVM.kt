package com.example.mvi.ui.splash.viewmodel

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.example.core.data.datastore.AppFlagDataStore
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
    private val appFlagDataStore: AppFlagDataStore
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
        val tutorialFlagFlow = appFlagDataStore.tutorialFlagFlow
            .map { SplashPartialChange.GetTutorialFlag.Data(it) as SplashPartialChange.GetTutorialFlag }
            .onStart { emit(SplashPartialChange.GetTutorialFlag.Loading) }
            .catch { }

        return merge(
            filterIsInstance<SplashViewIntent.Initial>()
                .flatMapConcat { tutorialFlagFlow }
        )
    }


}