package com.example.mvi.weather.remoterepo.weather

import com.example.mvi.weather.remoterepo.weather.model.forecast.ForecastDomainModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPIService {

    @GET("/data/2.5/forecast")
    suspend fun fetchForecast3DayByCity(
        @Query("q") city: String,
        @Query("appid") appId: String,
        @Query("cnt") cnt: String?,
        @Query("mode") mode: String?,
        @Query("units") units: String?,
        @Query("lang") language: String?
    ): List<ForecastDomainModel>

}