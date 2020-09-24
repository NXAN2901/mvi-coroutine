package com.example.mvi.weather.repo.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Snow(
    @Json(name = "3h")
    val snowVolume3: Float
)