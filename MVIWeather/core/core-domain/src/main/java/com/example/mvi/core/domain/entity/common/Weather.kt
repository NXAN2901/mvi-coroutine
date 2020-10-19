package com.example.mvi.core.domain.entity.common

data class Weather(
    val id: Long,
    val status: String,
    val description: String,
    val icon: String
)