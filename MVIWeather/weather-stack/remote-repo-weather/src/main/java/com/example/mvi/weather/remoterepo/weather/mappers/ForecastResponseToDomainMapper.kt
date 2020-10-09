package com.example.mvi.weather.remoterepo.weather.mappers

import com.example.mvi.core.domain.Mapper
import com.example.mvi.core.domain.entity.City
import com.example.mvi.core.domain.entity.FiveDayForecast
import com.example.mvi.core.domain.entity.ThreeHourForecast
import com.example.mvi.weather.remoterepo.weather.model.forecast.CityResponse
import com.example.mvi.weather.remoterepo.weather.model.forecast.FiveDayForecastResponse
import com.example.mvi.weather.remoterepo.weather.model.forecast.ThreeHourForecastResponse

class ForecastResponseToDomainMapper(
    private val threeHourForecastResponseToDomainMapper: Mapper<ThreeHourForecastResponse, ThreeHourForecast>,
    private val cityResponseToDomainMapper: Mapper<CityResponse, City>
) : Mapper<FiveDayForecastResponse, FiveDayForecast> {
    override fun invoke(response: FiveDayForecastResponse): FiveDayForecast {
        return FiveDayForecast(
            threeHourForecasts = response.threeHourForecastResponseList.map(
                threeHourForecastResponseToDomainMapper
            ),
            city = cityResponseToDomainMapper(response.city)
        )
    }

}