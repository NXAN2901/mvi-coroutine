package com.example.mvi.weather.repo.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class List(
    @Json(name = "dt")
    val timeForecast: Long,

    @Json(name = "main")
    val main: Main,

    @Json(name = "weather")
    val weather: Weather,

    @Json(name = "clouds")
    val clouds: Clouds,

    @Json(name = "wind")
    val wind: Wind,

    @Json(name = "visibility")
    val visibility: Int,

    // Probability of precipitation
    @Json(name = "pop")
    val pop: Float,

    @Json(name = "rain")
    val rain: Rain?,

    @Json(name = "snow")
    val snow: Snow?,

    // Time of data forecasted, ISO, UTC
    @Json(name = "dt_txt")
    val strDT: String


)