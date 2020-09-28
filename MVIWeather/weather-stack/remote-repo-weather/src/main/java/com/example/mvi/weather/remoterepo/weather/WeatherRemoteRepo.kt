package com.example.mvi.weather.remoterepo.weather

import com.example.mvi.weather.remoterepo.weather.model.forecast.ForecastDomainModel

interface WeatherRemoteRepo {

    suspend fun fetchForecast3DayByCity(
        city: String,
        appId: String,
        cnt: String? = null,
        mode: String? = "json",
        units: String? = "metric",
        language: String? = "en"
    ): ForecastDomainModel
}