package com.example.mvi.weather.repo.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Rain(

    @Json(name = "3h")
    val rainVolume3: Float
)