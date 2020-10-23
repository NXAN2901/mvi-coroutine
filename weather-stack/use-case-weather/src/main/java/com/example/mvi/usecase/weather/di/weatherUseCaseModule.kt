package com.example.mvi.usecase.weather.di

import com.example.mvi.usecase.weather.FetchCurrentWeatherUseCase
import com.example.mvi.usecase.weather.FetchForecastUseCase
import com.example.mvi.usecase.weather.RefreshCurrentWeatherUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.dsl.module

@FlowPreview
@ExperimentalCoroutinesApi
val weatherUseCaseModule = module {
    factory { FetchForecastUseCase(get(), get()) }
    factory { FetchCurrentWeatherUseCase(get(), get()) }
    factory { RefreshCurrentWeatherUseCase(get(), get()) }
}