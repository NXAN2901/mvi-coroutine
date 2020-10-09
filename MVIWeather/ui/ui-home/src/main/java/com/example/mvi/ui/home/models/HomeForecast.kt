package com.example.mvi.ui.home.models

import com.example.mvi.core.domain.entity.FiveDayForecast
import com.example.mvi.weather.remoterepo.weather.model.forecast.FiveDayForecastResponse

data class HomeForecast(
    val city: HomeCityForecast,
    val listThreeHourForecast: List<HomeThreeHourForecast>

) {
    constructor(domainFiveDay: FiveDayForecast) : this(
        city = HomeCityForecast(domainFiveDay.city),
        listThreeHourForecast = domainFiveDay.threeHourForecasts.map(::HomeThreeHourForecast)
    )
}