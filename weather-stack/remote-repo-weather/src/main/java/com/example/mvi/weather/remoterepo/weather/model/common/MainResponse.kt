package com.example.mvi.weather.remoterepo.weather.model.common

import com.google.gson.annotations.SerializedName

data class MainResponse (
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