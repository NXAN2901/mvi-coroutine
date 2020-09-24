package com.example.mvi.weather.repo.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.JsonQualifier

@JsonClass(generateAdapter = true)
data class Wind(
    @Json(name = "speed")
    val speed: Float,

    @Json(name = "deg")
    val deg: Int

)