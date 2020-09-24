package com.example.mvi.weather.repo.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Main (
    @Json(name = "temp")
    val temp: Float,

    @Json(name = "feels_like")
    val feelLike: Float,

    @Json(name = "temp_min")
    val tempMin: Float,

    @Json(name = "temp_max")
    val tempMax: Float,

    @Json(name = "pressure")
    val pressure: Int,

    @Json(name = "sea_level")
    val seaLevel: Int,

    @Json(name = "sea_level")
    val grndLevel: Int,

    @Json(name = "humidity")
    val humidity: Int,

    @Json(name = "temp_kf")
    val tempKf: Float

)