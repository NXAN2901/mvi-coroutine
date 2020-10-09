package com.example.mvi.weather.remoterepo.weather.mappers

import com.example.mvi.core.domain.Mapper
import com.example.mvi.core.domain.entity.Weather
import com.example.mvi.weather.remoterepo.weather.model.forecast.WeatherResponse

class WeatherResponseToDomainMapper : Mapper<WeatherResponse, Weather> {
    override fun invoke(response: WeatherResponse): Weather {
        return Weather(
            id = response.id,
            description = response.description,
            status = response.status,
            icon = response.icon
        )
    }

}