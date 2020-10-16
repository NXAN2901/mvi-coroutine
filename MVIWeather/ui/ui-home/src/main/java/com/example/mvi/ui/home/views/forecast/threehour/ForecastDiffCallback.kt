package com.example.mvi.ui.home.views.forecast.threehour

import com.example.mvi.android.core.adapter.ViewBindingDiffUtils

object ForecastDiffCallback : ViewBindingDiffUtils<HomeThreeHourForecastItem>() {
    override fun areItemsTheSame(oldItem: HomeThreeHourForecastItem, newItem: HomeThreeHourForecastItem): Boolean {
        return oldItem.timeStamp == newItem.timeStamp
    }

    override fun areContentsTheSame(oldItem: HomeThreeHourForecastItem, newItem: HomeThreeHourForecastItem): Boolean {
        return oldItem.timeStamp == newItem.timeStamp
    }

}