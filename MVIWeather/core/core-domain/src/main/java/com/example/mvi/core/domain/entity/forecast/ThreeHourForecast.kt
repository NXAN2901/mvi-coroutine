package com.example.mvi.core.domain.entity.forecast

import com.example.mvi.core.domain.entity.common.Main
import com.example.mvi.core.domain.entity.common.Weather
import com.example.mvi.core.domain.entity.common.Wind

data class ThreeHourForecast(
    val time: Long,
    val main: Main,
    val weatherList: List<Weather>,
    val wind: Wind
)