package com.example.mvi.weather.remoterepo.weather.mappers

import com.example.mvi.core.domain.Mapper
import com.example.mvi.core.domain.entity.common.MainDomain
import com.example.mvi.core.domain.entity.common.WeatherDomain
import com.example.mvi.core.domain.entity.current.CurrentWeatherDomain
import com.example.mvi.weather.remoterepo.weather.model.common.MainResponse
import com.example.mvi.weather.remoterepo.weather.model.common.WeatherResponse
import com.example.mvi.weather.remoterepo.weather.model.current.CurrentWeatherResponse

class CurrentWeatherResponseToDomainMapper(
    private val mainDomainMapper: Mapper<MainResponse, MainDomain>,
    private val weatherDomainMapper: Mapper<WeatherResponse, WeatherDomain>
) : Mapper<CurrentWeatherResponse, CurrentWeatherDomain> {
    override fun invoke(res: CurrentWeatherResponse): CurrentWeatherDomain {
        return CurrentWeatherDomain(
            id = res.id,
            timezone = res.timezone,
            name = res.name,
            dt = res.dt,
            main = mainDomainMapper(res.main),
            weathersInfo = res.weathersInfo.map(weatherDomainMapper)
        )
    }
}