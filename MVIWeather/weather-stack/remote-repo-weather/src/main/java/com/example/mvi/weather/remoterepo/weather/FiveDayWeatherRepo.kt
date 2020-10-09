package com.example.mvi.weather.remoterepo.weather

import com.example.mvi.core.domain.entity.FiveDayForecast
import com.example.mvi.weather.remoterepo.weather.model.forecast.FiveDayForecastResponse
import kotlinx.coroutines.flow.Flow

interface FiveDayWeatherRepo {

    fun getFiveDayForecast(city: String,
                           appId: String,
                           cnt: String? = null,
                           mode: String? = "json",
                           units: String? = "metric",
                           language: String? = "en"): Flow<FiveDayForecast>
}