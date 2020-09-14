package com.example.mvi.weather

import android.app.Application
import com.example.mvi.ui.intro.di.introVMModule
import com.example.mvi.ui.splash.di.splashVMModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            // declare used Android context
            androidContext(this@WeatherApp)
            // declare modules
            modules(listOf(
                splashVMModule,
                introVMModule
            ))
        }
    }
}