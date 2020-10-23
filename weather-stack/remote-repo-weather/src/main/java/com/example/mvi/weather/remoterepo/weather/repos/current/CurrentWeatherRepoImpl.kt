package com.example.mvi.weather.remoterepo.weather.repos.current

import android.util.Log
import com.example.mvi.core.domain.Mapper
import com.example.mvi.core.domain.entity.current.CurrentWeatherDomain
import com.example.mvi.coredispatchers.CoroutineDispatchers
import com.example.mvi.weather.remoterepo.weather.WeatherAPIService
import com.example.mvi.weather.remoterepo.weather.model.current.CurrentWeatherResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext

@FlowPreview
@ExperimentalCoroutinesApi
class CurrentWeatherRepoImpl(
    private val weatherAPIService: WeatherAPIService,
    private val dispatcher: CoroutineDispatchers,
    private val currentWeatherResponseToDomainMapper: Mapper<CurrentWeatherResponse, CurrentWeatherDomain>
) : CurrentWeatherRepo {

    private val _chaneChannel = ConflatedBroadcastChannel<Change>()

    private sealed class Change {
        data class Refreshed(val currentWeather: CurrentWeatherDomain) : Change()
    }

    private suspend fun fetchCurrentWeatherByCity(
        city: String,
        appId: String,
        units: String?
    ): CurrentWeatherDomain = withContext(dispatcher.io) {
        currentWeatherResponseToDomainMapper(
            weatherAPIService.fetchCurrentWeatherByCity(city = city, appId = appId, units = units)
        )
    }


    override fun getCurrentWeather(
        city: String,
        appId: String,
        units: String?
    ): Flow<CurrentWeatherDomain> = flow {
        val currentWeather = fetchCurrentWeatherByCity(city, appId, units)
        _chaneChannel.asFlow()
            .scan(currentWeather) { _, value ->
                when (value) {
                    is Change.Refreshed -> value.currentWeather
                }
            }
            .onEach { emit(it) }
            .catch { }
            .collect()
    }

    override suspend fun refreshCurrentWeather(city: String, appId: String, units: String?) =
        fetchCurrentWeatherByCity(city, appId, units).let {
            _chaneChannel.send(Change.Refreshed(it))
        }
}