package com.example.mvi.weather.remoterepo.weather.model.forecast

import com.example.mvi.core.domain.DomainModel
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlin.collections.List

data class ForecastDomainModel(

    @SerializedName("cod")
    val cod: String,

    @SerializedName("message")
    val message: Int,

    @SerializedName("cnt")
    val cnt: Int,

    @SerializedName("list")
    val list: ArrayList<com.example.mvi.weather.remoterepo.weather.model.forecast.List>,

    @SerializedName("city")
    val city: City
): DomainModel