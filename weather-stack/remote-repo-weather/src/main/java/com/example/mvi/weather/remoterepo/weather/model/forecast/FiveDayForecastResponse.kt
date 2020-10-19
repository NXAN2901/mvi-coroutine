package com.example.mvi.weather.remoterepo.weather.model.forecast

import com.example.mvi.core.domain.DomainModel
import com.google.gson.annotations.SerializedName

data class FiveDayForecastResponse(

    @SerializedName("cod")
    val cod: String,

    @SerializedName("message")
    val message: Int,

    @SerializedName("cnt")
    val cnt: Int,

    @SerializedName("list")
    val threeHourForecastResponseList: ArrayList<ThreeHourForecastResponse>,

    @SerializedName("city")
    val city: CityResponse
): DomainModel