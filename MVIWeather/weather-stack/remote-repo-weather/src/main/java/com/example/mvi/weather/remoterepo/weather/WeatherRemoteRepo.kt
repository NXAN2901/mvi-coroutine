package com.example.mvi.weather.remoterepo.weather

import com.example.mvi.weather.remoterepo.weather.model.forecast.ForecastDomainModel
import retrofit2.http.Query

interface WeatherRemoteRepo {

    suspend fun fetchForecast3DayByCity(
        city: String,
        appId: String,
        cnt: String? = null,
        mode: String? = "json",
        units: String? = "metric",
        language: String? = "en"
    ): List<ForecastDomainModel>
}