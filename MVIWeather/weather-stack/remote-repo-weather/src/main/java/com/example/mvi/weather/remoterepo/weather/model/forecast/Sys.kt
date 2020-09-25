package com.example.mvi.weather.remoterepo.weather.model.forecast

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Sys(

    // Part of the day (n - night, d - day)
    @SerializedName("pod")
    val pod: String
)