package com.example.mvi.usecase.weather.di

import com.example.mvi.usecase.weather.FetchCurrentWeatherUseCase
import com.example.mvi.usecase.weather.FetchForecastUseCase
import com.example.mvi.usecase.weather.RefreshCurrentWeatherUseCase
import com.example.mvi.usecase.weather.RefreshForecastUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.core.qualifier.named
import org.koin.dsl.module

@FlowPreview
@ExperimentalCoroutinesApi
val weatherUseCaseModule = module {
    factory { FetchForecastUseCase(get(), get(), get(named("appId"))) }
    factory { FetchCurrentWeatherUseCase(get(), get(), get(named("appId"))) }
    factory { RefreshCurrentWeatherUseCase(get(), get(), get(named("appId"))) }
    factory { RefreshForecastUseCase(get(), get(), get(named("appId"))) }
}