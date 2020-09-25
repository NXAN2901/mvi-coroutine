package com.example.mvi.weather.remoterepo.weather.model.forecast

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Wind(
    @SerializedName("speed")
    val speed: Float,

    @SerializedName("deg")
    val deg: Int

)