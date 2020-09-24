package com.example.mvi.weather.repo.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPIService {

    @GET("/data/2.5/forecast")
    suspend fun fetchForecast(
        @Query("q") city: String,
        @Query("cnt") cnt: String,
        @Query("appid") appId: String,
        @Query("mode") mode: String = "json",
        @Query("units") units: String = "metric",
        @Query("lang") language: String = "en"
    )

}