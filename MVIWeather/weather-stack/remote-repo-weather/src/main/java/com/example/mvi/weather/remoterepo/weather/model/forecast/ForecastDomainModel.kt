package com.example.mvi.weather.remoterepo.weather.model.forecast

import com.example.mvi.core.domain.DomainModel
import com.google.gson.annotations.SerializedName

data class ForecastDomainModel(

    @SerializedName("cod")
    val cod: String,

    @SerializedName("message")
    val message: Int,

    @SerializedName("cnt")
    val cnt: Int,

    @SerializedName("list")
    val threeHourForecastList: ArrayList<ThreeHourForecast>,

    @SerializedName("city")
    val city: City
): DomainModel