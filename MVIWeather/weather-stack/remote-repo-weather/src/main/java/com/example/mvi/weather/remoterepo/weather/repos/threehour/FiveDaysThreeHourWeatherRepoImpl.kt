package com.example.mvi.weather.remoterepo.weather.repos.threehour

import android.util.Log
import com.example.mvi.core.domain.Mapper
import com.example.mvi.core.domain.entity.forecast.FiveDayForecast
import com.example.mvi.coredispatchers.CoroutineDispatchers
import com.example.mvi.weather.remoterepo.weather.WeatherAPIService
import com.example.mvi.weather.remoterepo.weather.model.forecast.FiveDayForecastResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext

@FlowPreview
@ExperimentalCoroutinesApi
class FiveDaysThreeHourWeatherRepoImpl(
    private val weatherAPIService: WeatherAPIService,
    private val dispatcher: CoroutineDispatchers,
    private val forecastResponseToDomainMapper: Mapper<FiveDayForecastResponse, FiveDayForecast>
) : FiveDaysThreeHourWeatherRepo {

    private sealed class Change {
        data class Refreshed(val fiveDayForecast: FiveDayForecast) : Change()
    }

    private val _changeChannel = ConflatedBroadcastChannel<Change>()

    private suspend fun fetchForecast5DayByCity(
        city: String,
        appId: String,
        cnt: String?,
        mode: String?,
        units: String?,
        language: String?
    ): FiveDayForecast = withContext(dispatcher.io) {
        forecastResponseToDomainMapper(
            weatherAPIService.fetchForecast5DayByCity(
                city,
                appId,
                cnt,
                mode,
                units,
                language
            )
        )
    }

    override fun getFiveDayForecast(
        city: String,
        appId: String,
        cnt: String?,
        mode: String?,
        units: String?,
        language: String?
    ): Flow<FiveDayForecast> = flow {
        val forecasts = fetchForecast5DayByCity(city, appId, cnt, mode, units, language)
        _changeChannel.asFlow()
            .onEach { Log.e("ANNX", "[Weather Repo] Change $it") }
            .scan(forecasts) { _, value ->
                when (value) {
                    is Change.Refreshed -> value.fiveDayForecast
                }
            }
            .onEach { emit(it) }
            .catch {  }
            .collect()
    }

}