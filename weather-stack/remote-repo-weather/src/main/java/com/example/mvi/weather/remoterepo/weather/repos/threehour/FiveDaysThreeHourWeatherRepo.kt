package com.example.mvi.weather.remoterepo.weather.repos.threehour

import com.example.mvi.core.domain.entity.forecast.FiveDayForecastDomain
import kotlinx.coroutines.flow.Flow

interface FiveDaysThreeHourWeatherRepo {

    fun getFiveDayForecast(city: String,
                           appId: String,
                           cnt: String? = null,
                           mode: String? = "json",
                           units: String? = "metric",
                           language: String? = "en"): Flow<FiveDayForecastDomain>

    suspend fun refreshThreeHourForecast(
        city: String,
        appId: String,
        cnt: String? = null,
        mode: String? = "json",
        units: String? = "metric",
        language: String? = "en"
    )
}