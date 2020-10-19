package com.example.mvi.weather.remoterepo.weather

import com.example.mvi.weather.remoterepo.weather.model.current.CurrentWeatherResponse
import com.example.mvi.weather.remoterepo.weather.model.forecast.FiveDayForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPIService {

    @GET("data/2.5/forecast")
    suspend fun fetchForecast5DayByCity(
        @Query("q") city: String,
        @Query("appid") appId: String,
        @Query("cnt") cnt: String?,
        @Query("mode") mode: String?,
        @Query("units") units: String?,
        @Query("lang") language: String?
    ): FiveDayForecastResponse


    @GET("data/2.5/weather")
    suspend fun fetchCurrentWeatherByCity(
        @Query("q") city: String,
        @Query("appid") appId: String,
        @Query("units") units: String?
    ): CurrentWeatherResponse

}