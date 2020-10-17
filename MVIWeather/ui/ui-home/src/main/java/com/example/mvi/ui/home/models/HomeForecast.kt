package com.example.mvi.ui.home.models

import com.example.mvi.android.core.adapter.ViewBindingAdapterItem
import com.example.mvi.core.domain.entity.FiveDayForecast
import com.example.mvi.core.domain.entity.Main
import com.example.mvi.core.domain.entity.ThreeHourForecast
import com.example.mvi.core.domain.entity.Weather
import com.example.mvi.ui.home.views.forecast.content.HomeForecastItemViewType
import com.example.mvi.ui.home.views.forecast.threehour.ThreeHourForecastViewType

sealed class HomeForecast: ViewBindingAdapterItem {
    data class ThreeHour(
        val city: HomeCityForecast,
        val listThreeHourForecast: List<HomeThreeHourForecast>
    ) : HomeForecast() {
        constructor(domainFiveDay: FiveDayForecast) : this(
            city = HomeCityForecast(domainFiveDay.city),
            listThreeHourForecast = domainFiveDay.threeHourForecasts.map(::HomeThreeHourForecast)
        )

        override val itemViewType: Int
            get() = HomeForecastItemViewType.THREE_HOUR.ordinal
    }

    data class CurrentWeather(
        val status: String
    ) : HomeForecast() {
        override val itemViewType: Int
            get() = HomeForecastItemViewType.STATUS.ordinal

    }

    data class HomeThreeHourForecast(
        val time: Long,
        val forecastInfo: HomeForecastInfo,
        val weatherInfo: List<HomeWeatherInfo>
    ) : HomeForecast() {
        constructor(domainModel: ThreeHourForecast) : this(
            time = domainModel.time,
            forecastInfo = HomeForecastInfo(domainModel = domainModel.main),
            weatherInfo = domainModel.weatherList.map(::HomeWeatherInfo)
        )

        override val itemViewType: Int
            get() = ThreeHourForecastViewType.THREE_HOUR.ordinal
    }

    data class HomeForecastInfo(
        val temp: Float,
        val tempMax: Float,
        val tempMin: Float) {
        constructor(domainModel: Main) : this(
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
        constructor(domainModel: Weather) : this(
            id = domainModel.id,
            status = domainModel.status,
            description = domainModel.description,
            iconName = domainModel.icon
        )
    }
}