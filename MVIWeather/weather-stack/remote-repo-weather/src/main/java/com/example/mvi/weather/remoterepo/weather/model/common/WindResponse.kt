package com.example.mvi.weather.remoterepo.weather.model.common

import com.google.gson.annotations.SerializedName

data class WindResponse(
    @SerializedName("speed")
    val speed: Float,

    @SerializedName("deg")
    val deg: Int

)