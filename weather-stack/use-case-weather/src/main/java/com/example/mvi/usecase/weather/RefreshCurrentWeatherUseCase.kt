package com.example.mvi.usecase.weather

import com.example.mvi.core.usecase.NoResultUseCase
import com.example.mvi.coredispatchers.CoroutineDispatchers
import com.example.mvi.weather.remoterepo.weather.repos.current.CurrentWeatherRepo

class RefreshCurrentWeatherUseCase(
    dispatchers: CoroutineDispatchers,
    private val currentWeatherRepo: CurrentWeatherRepo
) : NoResultUseCase<RefreshCurrentWeatherUseCase.Params>(dispatchers.io) {

    data class Params(val city: String)

    override suspend fun execute(params: Params) = currentWeatherRepo.refreshCurrentWeather(
        params.city,
        appId = "9fbcd9f15fe6eb070ff628be464279e5",
        units = "metric"
    )
}