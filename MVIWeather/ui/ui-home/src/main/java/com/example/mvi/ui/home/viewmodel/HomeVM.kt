package com.example.mvi.ui.home.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.mvi.ui.base.BaseViewModel
import com.example.mvi.ui.home.*
import com.example.mvi.usecase.weather.FetchForecastUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*

@FlowPreview
@ExperimentalCoroutinesApi
class HomeVM(application: Application, private val fetchForecastUseCase: FetchForecastUseCase) :
    BaseViewModel(application) {

    private val _intentChannel = ConflatedBroadcastChannel<HomeViewIntent>()

    val viewState: StateFlow<HomeViewState>


    init {
        val initialVS = HomeViewState.initial()
        viewState = MutableStateFlow(initialVS)
        _intentChannel.asFlow().also { flowChannel ->
            merge(
                flowChannel.filterIsInstance<HomeViewIntent.Initial>().take(1),
                flowChannel.filterNot { it is HomeViewIntent.Initial }
            )
                .toPartialChange()
                .scan(initialVS) { vs, change -> change.reduce(vs) }
                .onEach { viewState.value = it }
                .catch { Log.e("ANNX", "Error $it") }
                .launchIn(viewModelScope)
        }
    }

    private fun Flow<HomeViewIntent>.toPartialChange(): Flow<HomePartialChange> {
        val forecastFlow = fetchForecasts()
            .onStart { emit(HomePartialChange.GetForecast.Loading) }
            .catch { emit(HomePartialChange.GetForecast.Error(it)) }
        return merge(
            filterIsInstance<HomeViewIntent.Initial>()
                .logIntent()
                .flatMapConcat { forecastFlow }
        )
    }


    suspend fun processIntent(intent: HomeViewIntent) = _intentChannel.send(intent)

    private fun fetchForecasts() = flow<HomePartialChange.GetForecast> {
        val forecastDomainData =
            fetchForecastUseCase(FetchForecastUseCase.Params("Thanh pho Ho Chi Minh,vn"))
        val forecast = HomeForecast(forecastDomainData.getOrThrow())
        emit(HomePartialChange.GetForecast.Data(forecast))
    }

    private fun <T : HomeViewIntent> Flow<T>.logIntent() =
        onEach { Log.d(HomeVM::class.simpleName, ">>> Intent: $it") }

}