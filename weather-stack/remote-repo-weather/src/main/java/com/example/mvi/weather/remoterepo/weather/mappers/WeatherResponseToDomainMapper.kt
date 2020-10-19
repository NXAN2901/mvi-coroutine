package com.example.mvi.weather.remoterepo.weather.mappers

import com.example.mvi.core.domain.Mapper
import com.example.mvi.core.domain.entity.common.WeatherDomain
import com.example.mvi.weather.remoterepo.weather.model.common.WeatherResponse

class WeatherResponseToDomainMapper : Mapper<WeatherResponse, WeatherDomain> {
    override fun invoke(response: WeatherResponse): WeatherDomain {
        return WeatherDomain(
            id = response.id,
            description = response.description,
            status = response.status,
            icon = response.icon
        )
    }

}