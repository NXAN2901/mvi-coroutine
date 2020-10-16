package com.example.mvi.ui.home.models

import com.example.mvi.core.domain.entity.FiveDayForecast

sealed class HomeForecast {
    data class ThreeHour(
        val city: HomeCityForecast,
        val listThreeHourForecast: List<HomeThreeHourForecast>
    ): HomeForecast() {
        constructor(domainFiveDay: FiveDayForecast) : this(
            city = HomeCityForecast(domainFiveDay.city),
            listThreeHourForecast = domainFiveDay.threeHourForecasts.map(::HomeThreeHourForecast)
        )
    }

    data class CurrentWeather(
        val status: String
    ): HomeForecast() {

    }
}