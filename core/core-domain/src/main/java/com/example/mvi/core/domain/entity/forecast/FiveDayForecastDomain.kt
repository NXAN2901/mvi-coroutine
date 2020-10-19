package com.example.mvi.core.domain.entity.forecast

import com.example.mvi.core.domain.entity.common.CityDomain

data class FiveDayForecastDomain(
    val threeHourForecasts: List<ThreeHourForecastDomain>,
    val city: CityDomain
)