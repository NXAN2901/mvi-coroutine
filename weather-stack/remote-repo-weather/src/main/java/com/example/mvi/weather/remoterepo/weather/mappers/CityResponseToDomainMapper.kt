package com.example.mvi.weather.remoterepo.weather.mappers

import com.example.mvi.core.domain.Mapper
import com.example.mvi.core.domain.entity.common.CityDomain
import com.example.mvi.weather.remoterepo.weather.model.forecast.CityResponse

class CityResponseToDomainMapper: Mapper<CityResponse, CityDomain> {
    override fun invoke(response: CityResponse): CityDomain {
        return CityDomain(
            id = response.id,
            name = response.name,
            lat = response.coordination.lat,
            lon = response.coordination.lon,
            timezone = response.timezone,
            country = response.country
        )
    }
}