package com.example.mvi.usecase.weather

import com.example.mvi.core.usecase.NoResultUseCase
import com.example.mvi.coredispatchers.CoroutineDispatchers
import com.example.mvi.weather.remoterepo.weather.repos.current.CurrentWeatherRepo

class RefreshCurrentWeatherUseCase(
    dispatchers: CoroutineDispatchers,
    private val currentWeatherRepo: CurrentWeatherRepo,
    private val appId: String,
) : NoResultUseCase<RefreshCurrentWeatherUseCase.Params>(dispatchers.io) {

    data class Params(val city: String)

    override suspend fun execute(params: Params) = currentWeatherRepo.refreshCurrentWeather(
        params.city,
        appId = appId,
        units = "metric"
    )
}