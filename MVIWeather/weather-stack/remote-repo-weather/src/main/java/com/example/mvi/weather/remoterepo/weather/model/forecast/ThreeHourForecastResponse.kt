package com.example.mvi.weather.remoterepo.weather.model.forecast

import com.google.gson.annotations.SerializedName

data class ThreeHourForecastResponse(
    @SerializedName("dt")
    val timeForecast: Long,

    @SerializedName("main")
    val main: MainResponse,

    @SerializedName("weather")
    val weatherResponse: ArrayList<WeatherResponse>,

    @SerializedName("clouds")
    val clouds: Clouds,

    @SerializedName("wind")
    val wind: WindResponse,

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