package com.example.mvi.usecase.weather

import com.example.mvi.core.domain.entity.forecast.FiveDayForecastDomain
import com.example.mvi.core.result.Result
import com.example.mvi.core.usecase.FlowUseCase
import com.example.mvi.coredispatchers.CoroutineDispatchers
import com.example.mvi.weather.remoterepo.weather.repos.threehour.FiveDaysThreeHourWeatherRepo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*

@ExperimentalCoroutinesApi
@FlowPreview
class FetchForecastUseCase(
    private val coroutineDispatchers: CoroutineDispatchers,
    private val threeHourWeatherRepo: FiveDaysThreeHourWeatherRepo,
    private val appId: String,
) : FlowUseCase<FetchForecastUseCase.Params, FiveDayForecastDomain>(coroutineDispatchers.io) {
    data class Params(val city: String)

    override fun execute(params: Params): Flow<Result<FiveDayForecastDomain>> {
        return flow {
            threeHourWeatherRepo.getFiveDayForecast(
                city = params.city,
                appId = appId,
                units = "metric"
            )
                .onEach { emit(Result.Success(data = it)) }
                .catch { emit(Result.Failure(throwable = it)) }
                .collect()
        }
    }
}