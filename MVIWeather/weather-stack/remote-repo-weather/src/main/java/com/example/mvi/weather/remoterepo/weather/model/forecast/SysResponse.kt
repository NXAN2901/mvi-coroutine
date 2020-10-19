package com.example.mvi.weather.remoterepo.weather.model.forecast

import com.google.gson.annotations.SerializedName

data class SysResponse(

    @SerializedName("type")
    val type: Int?,

    @SerializedName("id")
    val id: Long,

    @SerializedName("country")
    val country: String,

    @SerializedName("sunrise")
    val sunrise: Long,

    @SerializedName("sunset")
    val sunset: Long,

    // Part of the day (n - night, d - day)
    @SerializedName("pod")
    val pod: String?
)