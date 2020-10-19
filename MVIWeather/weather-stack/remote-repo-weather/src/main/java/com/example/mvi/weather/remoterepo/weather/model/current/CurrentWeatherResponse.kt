package com.example.mvi.weather.remoterepo.weather.model.current

import com.example.mvi.weather.remoterepo.weather.model.common.*
import com.example.mvi.weather.remoterepo.weather.model.forecast.CloudsResponse
import com.example.mvi.weather.remoterepo.weather.model.forecast.SysResponse
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(

    @SerializedName("id")
    val id: Long,

    @SerializedName("timezone")
    val timezone: Long,

    @SerializedName("coord")
    val coordination: CoordinationResponse,

    @SerializedName("weather")
    val weathersInfo: List<WeatherResponse>,

    @SerializedName("base")
    val base: String,

    @SerializedName("main")
    val main: MainResponse,

    @SerializedName("visibility")
    val visibility: Long,

    @SerializedName("wind")
    val wind: WindResponse,

    @SerializedName("rain")
    val rain: RainResponse,

    @SerializedName("clouds")
    val clouds: CloudsResponse,

    @SerializedName("dt")
    val dt: Long,

    @SerializedName("sys")
    val sys: SysResponse,

    @SerializedName("name")
    val name: String,

    @SerializedName("cod")
    val cod: Int

)