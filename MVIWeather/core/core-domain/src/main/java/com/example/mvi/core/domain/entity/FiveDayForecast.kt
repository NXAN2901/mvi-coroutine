package com.example.mvi.core.domain.entity

data class FiveDayForecast(
    val threeHourForecasts: List<ThreeHourForecast>,
    val city: City
)