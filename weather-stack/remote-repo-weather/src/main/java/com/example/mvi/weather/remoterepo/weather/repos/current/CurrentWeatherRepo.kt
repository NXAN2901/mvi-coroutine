package com.example.mvi.weather.remoterepo.weather.repos.current

import com.example.mvi.core.domain.entity.current.CurrentWeatherDomain
import kotlinx.coroutines.flow.Flow

interface CurrentWeatherRepo {
    fun getCurrentWeather(
        city: String,
        appId: String,
        units: String? = "metric",
    ): Flow<CurrentWeatherDomain>

    suspend fun refreshCurrentWeather(
        city: String,
        appId: String,
        units: String? = "metric"
    )
}