package com.example.mvi.ui.home.models

import com.example.mvi.core.domain.entity.Main
import com.example.mvi.core.domain.entity.ThreeHourForecast
import com.example.mvi.core.domain.entity.Weather
import com.example.mvi.weather.remoterepo.weather.model.forecast.MainResponse
import com.example.mvi.weather.remoterepo.weather.model.forecast.ThreeHourForecastResponse
import com.example.mvi.weather.remoterepo.weather.model.forecast.WeatherResponse

data class HomeThreeHourForecast(
    val time: Long,
    val forecastInfo: HomeForecastInfo,
    val weatherInfo: List<HomeWeatherInfo>
) {
    constructor(domainModel: ThreeHourForecast): this(
        time = domainModel.time,
        forecastInfo = HomeForecastInfo(domainModel = domainModel.main),
        weatherInfo = domainModel.weatherList.map(::HomeWeatherInfo)
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