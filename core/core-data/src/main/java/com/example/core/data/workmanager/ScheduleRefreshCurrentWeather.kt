package com.example.core.data.workmanager

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.mvi.weather.remoterepo.weather.repos.current.CurrentWeatherRepo
import kotlinx.coroutines.coroutineScope
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.qualifier.named

class ScheduleRefreshCurrentWeather(val context: Context, params: WorkerParameters) :
    CoroutineWorker(context, params), KoinComponent {

    private val currentWeatherRepo: CurrentWeatherRepo by inject()
    private val appId: String by inject(named("appId"))

    override suspend fun doWork(): Result = coroutineScope {
        currentWeatherRepo.refreshCurrentWeather(
            city = "Thanh pho Ho Chi Minh,vn",
            appId = appId,
            units = "metric"
        )
        Result.success()
    }

}