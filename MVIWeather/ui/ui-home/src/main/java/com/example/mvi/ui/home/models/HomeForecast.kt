package com.example.mvi.ui.home.models

import com.example.mvi.weather.remoterepo.weather.model.forecast.ForecastDomainModel

data class HomeForecast(
    val city: HomeCityForecast,
    val listThreeHourForecast: List<HomeThreeHourForecast>

) {
    constructor(domain: ForecastDomainModel) : this(
        city = HomeCityForecast(domain.city),
        listThreeHourForecast = domain.threeHourForecastList.map(::HomeThreeHourForecast)
    )
}