package com.example.mvi.core.domain.entity.forecast

import com.example.mvi.core.domain.entity.common.City

data class FiveDayForecast(
    val threeHourForecasts: List<ThreeHourForecast>,
    val city: City
)