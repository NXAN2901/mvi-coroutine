package com.example.mvi.weather.remoterepo.weather.repos.threehour

import com.example.mvi.core.domain.entity.forecast.FiveDayForecast
import kotlinx.coroutines.flow.Flow

interface FiveDaysThreeHourWeatherRepo {

    fun getFiveDayForecast(city: String,
                           appId: String,
                           cnt: String? = null,
                           mode: String? = "json",
                           units: String? = "metric",
                           language: String? = "en"): Flow<FiveDayForecast>
}