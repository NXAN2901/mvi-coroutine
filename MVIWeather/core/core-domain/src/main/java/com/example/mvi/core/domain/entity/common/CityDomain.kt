package com.example.mvi.core.domain.entity.common

data class CityDomain(
    val id: Long,
    val name: String,
    val lat: Float,
    val lon: Float,
    val timezone: Long,
    val country: String
)