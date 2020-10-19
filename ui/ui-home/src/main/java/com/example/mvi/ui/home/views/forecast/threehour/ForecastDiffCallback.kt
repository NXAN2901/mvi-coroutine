package com.example.mvi.ui.home.views.forecast.threehour

import com.example.mvi.android.core.adapter.ViewBindingDiffUtils
import com.example.mvi.ui.home.models.HomeForecast

object ForecastDiffCallback : ViewBindingDiffUtils<HomeForecast.HomeThreeHourForecast>() {

    override fun areItemsTheSame(
        oldItem: HomeForecast.HomeThreeHourForecast,
        newItem: HomeForecast.HomeThreeHourForecast
    ): Boolean {
        return oldItem.time == newItem.time
    }

    override fun areContentsTheSame(
        oldItem: HomeForecast.HomeThreeHourForecast,
        newItem: HomeForecast.HomeThreeHourForecast
    ): Boolean {
        return oldItem.time == newItem.time
    }

}