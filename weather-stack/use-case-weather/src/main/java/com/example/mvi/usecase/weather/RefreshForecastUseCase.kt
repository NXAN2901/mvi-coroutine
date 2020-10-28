package com.example.mvi.usecase.weather

import com.example.mvi.core.usecase.NoResultUseCase
import com.example.mvi.coredispatchers.CoroutineDispatchers
import com.example.mvi.weather.remoterepo.weather.repos.threehour.FiveDaysThreeHourWeatherRepo

class RefreshForecastUseCase(
    dispatchers: CoroutineDispatchers,
    private val fiveDaysThreeHourWeatherRepo: FiveDaysThreeHourWeatherRepo,
    private val appId: String,
) : NoResultUseCase<RefreshForecastUseCase.Params>(dispatchers.io) {

    data class Params(val city: String)

    override suspend fun execute(params: Params) =
        fiveDaysThreeHourWeatherRepo.refreshThreeHourForecast(
            params.city,
            appId = appId
        )
}