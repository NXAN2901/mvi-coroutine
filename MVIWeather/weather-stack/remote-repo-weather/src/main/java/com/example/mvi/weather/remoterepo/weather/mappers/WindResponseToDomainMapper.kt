package com.example.mvi.weather.remoterepo.weather.mappers

import com.example.mvi.core.domain.Mapper
import com.example.mvi.core.domain.entity.common.WindDomain
import com.example.mvi.weather.remoterepo.weather.model.common.WindResponse

class WindResponseToDomainMapper : Mapper<WindResponse, WindDomain> {
    override fun invoke(response: WindResponse): WindDomain {
        return WindDomain(
            deg = response.deg,
            speed = response.speed
        )
    }

}