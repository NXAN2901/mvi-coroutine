package com.example.mvi.weather.remoterepo.weather.model.forecast

import com.example.mvi.weather.remoterepo.weather.model.common.MainResponse
import com.example.mvi.weather.remoterepo.weather.model.common.RainResponse
import com.example.mvi.weather.remoterepo.weather.model.common.WeatherResponse
import com.example.mvi.weather.remoterepo.weather.model.common.WindResponse
import com.google.gson.annotations.SerializedName

data class ThreeHourForecastResponse(
    @SerializedName("dt")
    val timeForecast: Long,

    @SerializedName("main")
    val main: MainResponse,

    @SerializedName("weather")
    val weatherResponse: ArrayList<WeatherResponse>,

    @SerializedName("clouds")
    val clouds: CloudsResponse,

    @SerializedName("wind")
    val wind: WindResponse,

    @SerializedName("visibility")
    val visibility: Int,

    // Probability of precipitation
    @SerializedName("pop")
    val pop: Float,

    @SerializedName("rain")
    val rain: RainResponse?,

    @SerializedName("snow")
    val snow: Snow?,

    // Time of data forecasted, ISO, UTC
    @SerializedName("dt_txt")
    val strDT: String


)