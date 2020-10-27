package com.example.mvi.usecase.weather

import com.example.mvi.core.domain.entity.current.CurrentWeatherDomain
import com.example.mvi.core.result.Result
import com.example.mvi.core.usecase.FlowUseCase
import com.example.mvi.coredispatchers.CoroutineDispatchers
import com.example.mvi.weather.remoterepo.weather.repos.current.CurrentWeatherRepo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*

@ExperimentalCoroutinesApi
@FlowPreview
class FetchCurrentWeatherUseCase(
    coroutineDispatchers: CoroutineDispatchers,
    private val currentWeatherRepo: CurrentWeatherRepo,
    private val appId: String,
) : FlowUseCase<FetchCurrentWeatherUseCase.Params, CurrentWeatherDomain>(coroutineDispatchers.io) {
    data class Params(val city: String)

    override fun execute(params: Params): Flow<Result<CurrentWeatherDomain>> {
        return flow {
            currentWeatherRepo.getCurrentWeather(
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