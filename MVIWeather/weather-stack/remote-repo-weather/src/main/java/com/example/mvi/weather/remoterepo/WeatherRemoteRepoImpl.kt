package com.example.mvi.weather.remoterepo

import com.example.mvi.weather.remoterepo.weather.WeatherAPIService
import com.example.mvi.weather.remoterepo.weather.WeatherRemoteRepo
import com.example.mvi.weather.remoterepo.weather.model.forecast.ForecastDomainModel

class WeatherRemoteRepoImpl(private val weatherAPIService: WeatherAPIService) : WeatherRemoteRepo {
    override suspend fun fetchForecast3DayByCity(
        city: String,
        appId: String,
        cnt: String?,
        mode: String?,
        units: String?,
        language: String?
    ): ForecastDomainModel =
        weatherAPIService.fetchForecast3DayByCity(city, appId, cnt, mode, units, language)

}