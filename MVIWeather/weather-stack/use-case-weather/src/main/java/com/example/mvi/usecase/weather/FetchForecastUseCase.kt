package com.example.mvi.usecase.weather

import com.example.mvi.core.domain.entity.forecast.FiveDayForecast
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
    private val threeHourWeatherRepo: FiveDaysThreeHourWeatherRepo
) : FlowUseCase<FetchForecastUseCase.Params, FiveDayForecast>(coroutineDispatchers.io) {
    data class Params(val city: String)

    override fun execute(params: Params): Flow<Result<FiveDayForecast>> {
        return channelFlow {
            threeHourWeatherRepo.getFiveDayForecast(
                city = params.city,
                appId = "9fbcd9f15fe6eb070ff628be464279e5",
                units = "metric"
            )
                .onEach { channel.offer(Result.Success(data = it)) }
                .catch { channel.offer(Result.Failure(throwable = it)) }
                .collect()
        }
    }
}