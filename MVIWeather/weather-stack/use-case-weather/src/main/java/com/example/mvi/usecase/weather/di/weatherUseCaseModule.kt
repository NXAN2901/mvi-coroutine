package com.example.mvi.usecase.weather.di

import com.example.mvi.usecase.weather.FetchForecastUseCase
import org.koin.dsl.module

val weatherUseCaseModule = module {
    factory { FetchForecastUseCase(get(), get()) }
}