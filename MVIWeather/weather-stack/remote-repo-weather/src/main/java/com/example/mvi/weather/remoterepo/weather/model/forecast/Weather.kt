package com.example.mvi.weather.remoterepo.weather.model.forecast

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Weather(
    @SerializedName("id")
    val id: Long,

    @SerializedName("main")
    val status: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("icon")
    val icon: String
)