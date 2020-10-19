package com.example.mvi.weather.remoterepo.weather.model.forecast

import com.example.mvi.weather.remoterepo.weather.model.common.CoordinationResponse
import com.google.gson.annotations.SerializedName

data class CityResponse(
    @SerializedName("id")
    val id: Long,

    @SerializedName("name")
    val name: String,

    @SerializedName("coord")
    val coordination: CoordinationResponse,

    @SerializedName("country")
    val country: String,

    @SerializedName("population")
    val population: Int,

    @SerializedName("timezone")
    val timezone: Long,

    @SerializedName("sunrise")
    val sunrise: Long,

    @SerializedName("sunset")
    val sunset: Long
)
