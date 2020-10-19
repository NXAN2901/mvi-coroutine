package com.example.mvi.core.domain.entity.current

import com.example.mvi.core.domain.entity.common.Main

data class CurrentWeather(
    val id: Long,
    val timezone: Long,
    val name: String,
    val dt: Long,
    val main: Main
)