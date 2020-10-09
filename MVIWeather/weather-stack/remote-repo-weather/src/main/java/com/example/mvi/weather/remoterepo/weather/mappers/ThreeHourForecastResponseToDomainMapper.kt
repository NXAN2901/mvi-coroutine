package com.example.mvi.weather.remoterepo.weather.mappers

import com.example.mvi.core.domain.Mapper
import com.example.mvi.core.domain.entity.Main
import com.example.mvi.core.domain.entity.ThreeHourForecast
import com.example.mvi.core.domain.entity.Weather
import com.example.mvi.core.domain.entity.Wind
import com.example.mvi.weather.remoterepo.weather.model.forecast.MainResponse
import com.example.mvi.weather.remoterepo.weather.model.forecast.ThreeHourForecastResponse
import com.example.mvi.weather.remoterepo.weather.model.forecast.WeatherResponse
import com.example.mvi.weather.remoterepo.weather.model.forecast.WindResponse

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