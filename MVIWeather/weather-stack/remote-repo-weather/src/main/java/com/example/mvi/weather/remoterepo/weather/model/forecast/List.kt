package com.example.mvi.weather.remoterepo.weather.model.forecast

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class List(
    @SerializedName("dt")
    val timeForecast: Long,

    @SerializedName("main")
    val main: Main,

    @SerializedName("weather")
    val weather: ArrayList<Weather>,

    @SerializedName("clouds")
    val clouds: Clouds,

    @SerializedName("wind")
    val wind: Wind,

    @SerializedName("visibility")
    val visibility: Int,

    // Probability of precipitation
    @SerializedName("pop")
    val pop: Float,

    @SerializedName("rain")
    val rain: Rain?,

    @SerializedName("snow")
    val snow: Snow?,

    // Time of data forecasted, ISO, UTC
    @SerializedName("dt_txt")
    val strDT: String


)