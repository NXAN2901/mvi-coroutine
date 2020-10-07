package com.example.mvi.weather.remoterepo.weather.model.forecast

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Main (
    @SerializedName("temp")
    val temp: Float,

    @SerializedName("feels_like")
    val feelLike: Float,

    @SerializedName("temp_min")
    val tempMin: Float,

    @SerializedName("temp_max")
    val tempMax: Float,

    @SerializedName("pressure")
    val pressure: Int,

    @SerializedName("sea_level")
    val seaLevel: Int,

    @SerializedName("grnd_level")
    val grndLevel: Int,

    @SerializedName("humidity")
    val humidity: Int,

    @SerializedName("temp_kf")
    val tempKf: Float

)