package com.example.mvi.weather

import android.app.Application
import com.example.mvi.coredispatchers.di.dispatcherModule
import com.example.mvi.ui.home.di.homeVMModule
import com.example.mvi.ui.intro.di.introVMModule
import com.example.mvi.ui.splash.di.splashVMModule
import com.example.mvi.usecase.weather.di.weatherUseCaseModule
import com.example.mvi.weather.di.networkModule
import com.example.mvi.weather.remoterepo.weather.di.weatherRepoModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@ExperimentalCoroutinesApi
@FlowPreview
class WeatherApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            // declare used Android context
            androidContext(this@WeatherApp)
            // declare modules
            modules(
                listOf(
                    networkModule,
                    dispatcherModule,
                    weatherUseCaseModule,
                    splashVMModule,
                    introVMModule,
                    homeVMModule,
                    weatherRepoModule
                )
            )
        }
    }
}