package com.example.mvi.weather.remoterepo.weather.di

import com.example.mvi.weather.remoterepo.weather.mappers.*
import org.koin.dsl.module

val weatherRepoModule = module {
    factory { MainResponseToMainDomainMapper() }

    factory { WeatherResponseToDomainMapper() }

    factory { CityResponseToDomainMapper() }

    factory { WindResponseToDomainMapper() }

    factory { ThreeHourForecastResponseToDomainMapper(
        get<MainResponseToMainDomainMapper>(),
        get<WeatherResponseToDomainMapper>(),
        get<WindResponseToDomainMapper>()
    ) }

    factory { ForecastResponseToDomainMapper(
        get<ThreeHourForecastResponseToDomainMapper>(),
        get<CityResponseToDomainMapper>()
    ) }
}