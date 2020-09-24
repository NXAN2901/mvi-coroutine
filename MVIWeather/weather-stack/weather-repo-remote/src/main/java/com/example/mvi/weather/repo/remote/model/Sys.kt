package com.example.mvi.weather.repo.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Sys(

    // Part of the day (n - night, d - day)
    @Json(name = "pod")
    val pod: String
)