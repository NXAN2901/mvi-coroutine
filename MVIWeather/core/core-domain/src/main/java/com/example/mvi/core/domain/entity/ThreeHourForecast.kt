package com.example.mvi.core.domain.entity

data class ThreeHourForecast(
    val time: Long,
    val main: Main,
    val weatherList: List<Weather>,
    val wind: Wind
)