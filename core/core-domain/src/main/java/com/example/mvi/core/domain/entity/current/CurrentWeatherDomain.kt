package com.example.mvi.core.domain.entity.current

import com.example.mvi.core.domain.entity.common.MainDomain
import com.example.mvi.core.domain.entity.common.WeatherDomain

data class CurrentWeatherDomain(
    val id: Long,
    val timezone: Long,
    val name: String,
    val dt: Long,
    val main: MainDomain,
    val weathersInfo: List<WeatherDomain>
)