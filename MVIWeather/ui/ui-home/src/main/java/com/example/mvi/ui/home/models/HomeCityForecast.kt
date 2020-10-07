package com.example.mvi.ui.home.models

import com.example.mvi.weather.remoterepo.weather.model.forecast.City

data class HomeCityForecast(
    val id: Long,
    val name: String,
    val lat: Float,
    val lon: Float,
    val country: String,
    val timezone: Long
) {
    constructor(domainModel: City) : this(
        id = domainModel.id,
        name = domainModel.name,
        lat = domainModel.coordination.lat,
        lon = domainModel.coordination.lon,
        country = domainModel.country,
        timezone = domainModel.timezone
    )
}