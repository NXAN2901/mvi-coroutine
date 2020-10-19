package com.example.mvi.weather.remoterepo.weather.mappers

import com.example.mvi.core.domain.Mapper
import com.example.mvi.core.domain.entity.common.Main
import com.example.mvi.core.domain.entity.current.CurrentWeather
import com.example.mvi.weather.remoterepo.weather.model.common.MainResponse
import com.example.mvi.weather.remoterepo.weather.model.current.CurrentWeatherResponse

class CurrentWeatherResponseToDomainMapper(
    private val mainDomainMapper: Mapper<MainResponse, Main>
) : Mapper<CurrentWeatherResponse, CurrentWeather> {
    override fun invoke(res: CurrentWeatherResponse): CurrentWeather {
        return CurrentWeather(
            id = res.id,
            timezone = res.timezone,
            name = res.name,
            dt = res.dt,
            main = mainDomainMapper(res.main)
        )
    }
}