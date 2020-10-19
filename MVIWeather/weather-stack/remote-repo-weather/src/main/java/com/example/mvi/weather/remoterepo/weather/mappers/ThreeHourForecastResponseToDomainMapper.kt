package com.example.mvi.weather.remoterepo.weather.mappers

import com.example.mvi.core.domain.Mapper
import com.example.mvi.core.domain.entity.common.MainDomain
import com.example.mvi.core.domain.entity.common.WeatherDomain
import com.example.mvi.core.domain.entity.common.WindDomain
import com.example.mvi.core.domain.entity.forecast.ThreeHourForecastDomain
import com.example.mvi.weather.remoterepo.weather.model.common.MainResponse
import com.example.mvi.weather.remoterepo.weather.model.common.WeatherResponse
import com.example.mvi.weather.remoterepo.weather.model.common.WindResponse
import com.example.mvi.weather.remoterepo.weather.model.forecast.ThreeHourForecastResponse

class ThreeHourForecastResponseToDomainMapper(
    private val mainResponseToMainDomain: Mapper<MainResponse, MainDomain>,
    private val weatherResponseToDomainMapper: Mapper<WeatherResponse, WeatherDomain>,
    private val windResponseToDomainMapper: Mapper<WindResponse, WindDomain>
) : Mapper<ThreeHourForecastResponse, ThreeHourForecastDomain> {
    override fun invoke(response: ThreeHourForecastResponse): ThreeHourForecastDomain {
        return ThreeHourForecastDomain(
            time = response.timeForecast,
            main = mainResponseToMainDomain(response.main),
            weatherList = response.weatherResponse.map(weatherResponseToDomainMapper),
            wind = windResponseToDomainMapper(response.wind)
        )
    }

}