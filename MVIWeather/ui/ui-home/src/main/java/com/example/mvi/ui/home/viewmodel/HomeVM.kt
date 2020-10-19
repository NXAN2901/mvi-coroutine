package com.example.mvi.ui.home.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.mvi.ui.base.BaseViewModel
import com.example.mvi.ui.home.HomePartialChange
import com.example.mvi.ui.home.HomeViewIntent
import com.example.mvi.ui.home.HomeViewState
import com.example.mvi.ui.home.models.HomeForecast
import com.example.mvi.usecase.weather.FetchCurrentWeatherUseCase
import com.example.mvi.usecase.weather.FetchForecastUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

@FlowPreview
@ExperimentalCoroutinesApi
class HomeVM(
    application: Application,
    private val fetchForecastUseCase: FetchForecastUseCase,
    private val fetchCurrentWeatherUseCase: FetchCurrentWeatherUseCase
) : BaseViewModel(application) {

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
                .onEach {
                    delay(500)
                    viewState.value = it
                }
                .catch { Log.e("ANNX", "Error $it") }
                .launchIn(viewModelScope)
        }
    }

    private fun Flow<HomeViewIntent>.toPartialChange(): Flow<HomePartialChange> {
        val homeWeatherFlow =
            merge(
                fetchCurrentWeather(),
                fetchForecasts()
            ).scan(ArrayList<HomeForecast>()) { acc, change ->
                if (change is HomeForecast.CurrentWeather) {
                    acc.add(0, change)
                } else {
                    acc.add(change)
                }
                acc
            }
                .map { HomePartialChange.GetForecast.Data(it) as HomePartialChange }
                .onStart { emit(HomePartialChange.GetForecast.Loading)}
                .catch { emit(HomePartialChange.GetForecast.Error(it)) }


        return merge(
            filterIsInstance<HomeViewIntent.Initial>()
                .logIntent()
                .flatMapConcat { homeWeatherFlow }
        )
    }

    suspend fun processIntent(intent: HomeViewIntent) = _intentChannel.send(intent)

    private fun fetchForecasts() = flow {
        fetchForecastUseCase(FetchForecastUseCase.Params("Thanh pho Ho Chi Minh,vn"))
            .onEach {
                emit(HomeForecast.ThreeHour(it.getOrThrow()))
            }.collect()
    }


    private fun fetchCurrentWeather() = flow {
        fetchCurrentWeatherUseCase(FetchCurrentWeatherUseCase.Params(city = "Thanh pho Ho Chi Minh,vn"))
            .onEach {
                emit(HomeForecast.CurrentWeather(it.getOrThrow()))
            }.collect()
    }

    private fun <T : HomeViewIntent> Flow<T>.logIntent() =
        onEach { Log.d(HomeVM::class.simpleName, ">>> Intent: $it") }

}