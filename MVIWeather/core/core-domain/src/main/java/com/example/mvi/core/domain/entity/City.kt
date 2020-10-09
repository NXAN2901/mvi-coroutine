package com.example.mvi.core.domain.entity

data class City(
    val id: Long,
    val name: String,
    val lat: Float,
    val lon: Float,
    val timezone: Long,
    val country: String
)