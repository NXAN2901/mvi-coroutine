package com.example.mvi.weather.repo.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class City(
    @Json(name = "id")
    val id: Long,

    @Json(name = "name")
    val name: String,

    @Json(name = "coord")
    val coordination: Coordination,

    @Json(name = "country")
    val country: String,

    @Json(name = "population")
    val population: Int,

    @Json(name = "timezone")
    val timezone: Int,

    @Json(name = "sunrise")
    val sunrise: Long,

    @Json(name = "sunset")
    val sunset: Long
)

@JsonClass(generateAdapter = true)
data class Coordination(
    @Json(name = "lat")
    val lat: Float,
    @Json(name = "lon")
    val lon: Float
)
