package com.example.mvi.weather.remoterepo.weather.model.common

import com.google.gson.annotations.SerializedName

data class CoordinationResponse(
    @SerializedName("lat")
    val lat: Float,
    @SerializedName("lon")
    val lon: Float
)