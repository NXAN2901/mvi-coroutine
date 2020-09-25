package com.example.mvi.usecase.weather

import android.util.Log
import com.example.mvi.core.result.Failure
import com.example.mvi.core.result.Result
import com.example.mvi.core.result.Success
import com.example.mvi.core.usecase.ResultUseCase
import com.example.mvi.coredispatchers.CoroutineDispatchers
import com.example.mvi.weather.remoterepo.weather.WeatherRemoteRepo
import com.example.mvi.weather.remoterepo.weather.model.forecast.ForecastDomainModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineDispatcher

class FetchForecastUseCase(
    private val coroutineDispatchers: CoroutineDispatchers,
    private val weatherRemoteRepo: WeatherRemoteRepo
) : ResultUseCase<List<ForecastDomainModel>, FetchForecastUseCase.Params>() {
    data class Params(val city: String)

    override val workDispatcher: CoroutineDispatcher
        get() = coroutineDispatchers.io

    override suspend fun run(params: Params): Result<List<ForecastDomainModel>> {
        runCatching {
            val forecasts = weatherRemoteRepo.fetchForecast3DayByCity(
                city = params.city,
                appId = "9fbcd9f15fe6eb070ff628be464279e5"
            )
            return Success(forecasts)
        }.onFailure {
            Log.e("ANNX", "Fetch Forecast error $it")
           return Failure(it)
        }

        throw CancellationException()
    }
}