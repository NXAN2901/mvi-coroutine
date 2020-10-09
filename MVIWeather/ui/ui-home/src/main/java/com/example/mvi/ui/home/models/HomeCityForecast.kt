package com.example.mvi.ui.home.models

import com.example.mvi.core.domain.entity.City
import com.example.mvi.weather.remoterepo.weather.model.forecast.CityResponse

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
        lat = domainModel.lat,
        lon = domainModel.lon,
        country = domainModel.country,
        timezone = domainModel.timezone
    )
}