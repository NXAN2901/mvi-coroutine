package com.example.mvi.ui.home.models

import com.example.mvi.android.core.adapter.ViewBindingAdapterItem
import com.example.mvi.core.domain.entity.common.MainDomain
import com.example.mvi.core.domain.entity.common.WeatherDomain
import com.example.mvi.core.domain.entity.current.CurrentWeatherDomain
import com.example.mvi.core.domain.entity.forecast.FiveDayForecastDomain
import com.example.mvi.core.domain.entity.forecast.ThreeHourForecastDomain
import com.example.mvi.ui.home.views.forecast.content.HomeForecastItemViewType
import com.example.mvi.ui.home.views.forecast.threehour.ThreeHourForecastViewType

sealed class HomeForecast : ViewBindingAdapterItem {
    data class ThreeHour(
        val city: HomeCityForecast,
        val listThreeHourForecast: List<HomeThreeHourForecast>
    ) : HomeForecast() {
        constructor(domainFiveDay: FiveDayForecastDomain) : this(
            city = HomeCityForecast(domainFiveDay.city),
            listThreeHourForecast = domainFiveDay.threeHourForecasts.map(::HomeThreeHourForecast)
        )

        override val itemViewType: Int
            get() = HomeForecastItemViewType.THREE_HOUR.ordinal
    }

    data class CurrentWeather(
        val name: String,
        val tempMax: Float,
        val tempMin: Float,
        val currentTemp: Float,
        val status: String,
        val time: Long,
        val iconName: String
    ) : HomeForecast() {

        constructor(domainModel: CurrentWeatherDomain) : this(
            name = domainModel.name,
            tempMax = domainModel.main.tempMax,
            tempMin = domainModel.main.tempMin,
            currentTemp = domainModel.main.temp,
            time = domainModel.dt,
            status = domainModel.weathersInfo[0].description,
            iconName = domainModel.weathersInfo[0].icon
        )

        override val itemViewType: Int
            get() = HomeForecastItemViewType.STATUS.ordinal

    }

    data class HomeThreeHourForecast(
        val time: Long,
        val forecastInfo: HomeForecastInfo,
        val weatherInfo: List<HomeWeatherInfo>
    ) : HomeForecast() {
        constructor(domainModel: ThreeHourForecastDomain) : this(
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
        val tempMin: Float
    ) {
        constructor(domainModel: MainDomain) : this(
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
        constructor(domainModel: WeatherDomain) : this(
            id = domainModel.id,
            status = domainModel.status,
            description = domainModel.description,
            iconName = domainModel.icon
        )
    }
}