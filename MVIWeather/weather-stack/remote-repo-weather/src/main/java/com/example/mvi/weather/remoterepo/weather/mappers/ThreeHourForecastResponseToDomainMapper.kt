package com.example.mvi.weather.remoterepo.weather.mappers

import com.example.mvi.core.domain.Mapper
import com.example.mvi.core.domain.entity.common.Main
import com.example.mvi.core.domain.entity.forecast.ThreeHourForecast
import com.example.mvi.core.domain.entity.common.Weather
import com.example.mvi.core.domain.entity.common.Wind
import com.example.mvi.weather.remoterepo.weather.model.common.MainResponse
import com.example.mvi.weather.remoterepo.weather.model.common.WeatherResponse
import com.example.mvi.weather.remoterepo.weather.model.forecast.ThreeHourForecastResponse
import com.example.mvi.weather.remoterepo.weather.model.common.WindResponse

class ThreeHourForecastResponseToDomainMapper(
    private val mainResponseToMainDomain: Mapper<MainResponse, Main>,
    private val weatherResponseToDomainMapper: Mapper<WeatherResponse, Weather>,
    private val windResponseToDomainMapper: Mapper<WindResponse, Wind>
) : Mapper<ThreeHourForecastResponse, ThreeHourForecast> {
    override fun invoke(response: ThreeHourForecastResponse): ThreeHourForecast {
        return ThreeHourForecast(
            time = response.timeForecast,
            main = mainResponseToMainDomain(response.main),
            weatherList = response.weatherResponse.map(weatherResponseToDomainMapper),
            wind = windResponseToDomainMapper(response.wind)
        )
    }

}