package com.example.mvi.weather.remoterepo.weather.repos.current

import com.example.mvi.core.domain.entity.current.CurrentWeather
import kotlinx.coroutines.flow.Flow

interface CurrentWeatherRepo {
    fun getCurrentWeather(city: String,
                           appId: String,
                           units: String? = "metric",): Flow<CurrentWeather>
}