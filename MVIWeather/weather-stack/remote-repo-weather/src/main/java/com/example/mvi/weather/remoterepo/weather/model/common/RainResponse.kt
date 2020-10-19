package com.example.mvi.weather.remoterepo.weather.model.common

import com.google.gson.annotations.SerializedName

data class RainResponse(

    @SerializedName("3h")
    val rainVolume3: Float?,

    @SerializedName("1h")
    val rainVolume1: Float?
)