package com.example.mvi.weather.remoterepo.weather.mappers

import com.example.mvi.core.domain.Mapper
import com.example.mvi.core.domain.entity.common.CityDomain
import com.example.mvi.core.domain.entity.forecast.FiveDayForecastDomain
import com.example.mvi.core.domain.entity.forecast.ThreeHourForecastDomain
import com.example.mvi.weather.remoterepo.weather.model.forecast.CityResponse
import com.example.mvi.weather.remoterepo.weather.model.forecast.FiveDayForecastResponse
import com.example.mvi.weather.remoterepo.weather.model.forecast.ThreeHourForecastResponse

class ForecastResponseToDomainMapper(
    private val threeHourForecastResponseToDomainMapper: Mapper<ThreeHourForecastResponse, ThreeHourForecastDomain>,
    private val cityResponseToDomainMapper: Mapper<CityResponse, CityDomain>
) : Mapper<FiveDayForecastResponse, FiveDayForecastDomain> {
    override fun invoke(response: FiveDayForecastResponse): FiveDayForecastDomain {
        return FiveDayForecastDomain(
            threeHourForecasts = response.threeHourForecastResponseList.map(
                threeHourForecastResponseToDomainMapper
            ),
            city = cityResponseToDomainMapper(response.city)
        )
    }

}