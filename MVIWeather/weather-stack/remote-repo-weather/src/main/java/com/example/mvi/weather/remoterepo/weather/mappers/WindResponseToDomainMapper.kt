package com.example.mvi.weather.remoterepo.weather.mappers

import com.example.mvi.core.domain.Mapper
import com.example.mvi.core.domain.entity.Wind
import com.example.mvi.weather.remoterepo.weather.model.forecast.WindResponse

class WindResponseToDomainMapper : Mapper<WindResponse, Wind> {
    override fun invoke(response: WindResponse): Wind {
        return Wind(
            deg = response.deg,
            speed = response.speed
        )
    }

}