package com.example.mvi.ui.home.models

import com.example.mvi.weather.remoterepo.weather.model.forecast.Main
import com.example.mvi.weather.remoterepo.weather.model.forecast.ThreeHourForecast
import com.example.mvi.weather.remoterepo.weather.model.forecast.Weather

data class HomeThreeHourForecast(
    val time: Long,
    val forecastInfo: HomeForecastInfo,
    val weatherInfo: List<HomeWeatherInfo>
) {
    constructor(domainModel: ThreeHourForecast): this(
        time = domainModel.timeForecast,
        forecastInfo = HomeForecastInfo(domainModel = domainModel.main),
        weatherInfo = domainModel.weather.map(::HomeWeatherInfo)
    )
}

data class HomeForecastInfo(val temp: Float, val tempMax: Float, val tempMin: Float) {
    constructor(domainModel: Main): this(
        temp = domainModel.temp,
        tempMax = domainModel.tempMax,
        tempMin = domainModel.tempMin
    )
}

data class HomeWeatherInfo(
    val id: Long,
    val status: String,
    val description: String,
    val iconName: String
) {
    constructor(domainModel: Weather): this(
        id = domainModel.id,
        status = domainModel.status,
        description = domainModel.description,
        iconName = domainModel.icon
    )
}