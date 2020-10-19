package com.example.mvi.core.domain.entity.forecast

import com.example.mvi.core.domain.entity.common.MainDomain
import com.example.mvi.core.domain.entity.common.WeatherDomain
import com.example.mvi.core.domain.entity.common.WindDomain

data class ThreeHourForecastDomain(
    val time: Long,
    val main: MainDomain,
    val weatherList: List<WeatherDomain>,
    val wind: WindDomain
)