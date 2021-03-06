package com.example.mvi.ui.home.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.work.*
import com.example.core.data.usecase.UpdateAppStateUseCase
import com.example.core.data.workmanager.ScheduleRefreshCurrentWeather
import com.example.mvi.data.datastore.AppPreferences
import com.example.mvi.ui.base.BaseViewModel
import com.example.mvi.ui.home.HomePartialChange
import com.example.mvi.ui.home.HomeViewIntent
import com.example.mvi.ui.home.HomeViewState
import com.example.mvi.ui.home.models.HomeForecast
import com.example.mvi.usecase.weather.FetchCurrentWeatherUseCase
import com.example.mvi.usecase.weather.FetchForecastUseCase
import com.example.mvi.usecase.weather.RefreshCurrentWeatherUseCase
import com.example.mvi.usecase.weather.RefreshForecastUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

@FlowPreview
@ExperimentalCoroutinesApi
class HomeVM(
    application: Application,
    private val fetchForecastUseCase: FetchForecastUseCase,
    private val fetchCurrentWeatherUseCase: FetchCurrentWeatherUseCase,
    private val refreshCurrentWeatherUseCase: RefreshCurrentWeatherUseCase,
    private val refreshForecastUseCase: RefreshForecastUseCase,
    private val updateAppStateUseCase: UpdateAppStateUseCase,
) : BaseViewModel(application) {

    private val _intentChannel = ConflatedBroadcastChannel<HomeViewIntent>()

    val viewState: StateFlow<HomeViewState>

    init {
        val initialVS = HomeViewState.initial()
        viewState = MutableStateFlow(initialVS)
        _intentChannel.asFlow()
            .distinctUntilChanged { old, new ->
                if (new is HomeViewIntent.Refresh) {
                    false
                } else old == new
            }
            .toPartialChange()
            .scan(initialVS) { vs, change -> change.reduce(vs) }
            .onEach {
                viewState.value = it
            }
            .catch { Log.e("ANNX", "Error $it") }
            .launchIn(viewModelScope)

        val schedule: WorkRequest = PeriodicWorkRequestBuilder<ScheduleRefreshCurrentWeather>(
            SCHEDULE_REPEAT_INTERVAL,
            TimeUnit.MINUTES,
        )
            .addTag(SCHEDULE_WORKER_TAG)
            .setConstraints(
                Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build()
            )
            .build()

        WorkManager.getInstance(application)
            .enqueue(schedule)

        viewModelScope.launch {
            updateAppStateUseCase(UpdateAppStateUseCase.Params(AppPreferences.AppState.SIGNED_IN))
        }
    }

    override fun onCleared() {
        WorkManager.getInstance(getApplication()).cancelAllWorkByTag(SCHEDULE_WORKER_TAG)
        super.onCleared()
    }

    private fun Flow<HomeViewIntent>.toPartialChange(): Flow<HomePartialChange> {
        val homeWeatherFlow =
            merge(
                fetchCurrentWeather(),
                fetchForecasts()
            )
                .scan(ArrayList<HomeForecast>()) { acc, change ->
                    if (change is HomeForecast.CurrentWeather) {
                        if (acc.isNotEmpty() && acc.first() is HomeForecast.CurrentWeather) {
                            acc[0] = change
                        } else {
                            acc.add(0, change)
                        }
                    } else {
                        if (acc.size > 1) {
                            acc[1] = change
                        } else {
                            acc.add(change)
                        }
                    }
                    acc
                }
                .map { HomePartialChange.GetForecast.Data(it) as HomePartialChange }
                .onStart { emit(HomePartialChange.GetForecast.Loading) }
                .catch { emit(HomePartialChange.GetForecast.Error(it)) }

        val refreshCurrentWeatherFlow = refreshCurrentWeather()
            .onStart { emit(HomePartialChange.GetForecast.Loading) }
            .catch { emit(HomePartialChange.GetForecast.Error(it)) }

        return merge(
            filterIsInstance<HomeViewIntent.Initial>()
                .logIntent()
                .flatMapConcat { homeWeatherFlow },
            filterIsInstance<HomeViewIntent.Refresh>()
                .filter { viewState.value.let { !it.isLoading && it.error == null } }
                .flatMapConcat { refreshCurrentWeatherFlow }
        )
    }

    suspend fun processIntent(intent: HomeViewIntent) = _intentChannel.send(intent)

    private fun refreshCurrentWeather() = flow<HomePartialChange> {
        refreshCurrentWeatherUseCase(
            RefreshCurrentWeatherUseCase.Params("Thanh pho Ho Chi Minh,vn")
        )

        refreshForecastUseCase(
            RefreshForecastUseCase.Params(city = "Thanh pho Ho Chi Minh,vn")
        )
    }

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

    companion object {
        private const val SCHEDULE_WORKER_TAG = "Schedule"
        private const val SCHEDULE_REPEAT_INTERVAL = 15L
    }
}