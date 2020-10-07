package com.example.mvi.weather.remoterepo.weather.model.forecast

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class City(
    @SerializedName("id")
    val id: Long,

    @SerializedName("name")
    val name: String,

    @SerializedName("coord")
    val coordination: Coordination,

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

data class Coordination(
    @SerializedName("lat")
    val lat: Float,
    @SerializedName("lon")
    val lon: Float
)
