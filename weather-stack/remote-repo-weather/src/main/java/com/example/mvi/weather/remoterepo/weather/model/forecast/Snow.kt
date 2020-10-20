package com.example.mvi.weather.remoterepo.weather.model.forecast

import com.google.gson.annotations.SerializedName

data class Snow(
    @SerializedName("3h")
    val snowVolume3: Float
)