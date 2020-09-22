package com.example.mvi.ui.home.view.forecast

import com.example.mvi.android.core.adapter.ViewBindingDiffUtils

object ForecastDiffCallback : ViewBindingDiffUtils<HomeForecastItem>() {
    override fun areItemsTheSame(oldItem: HomeForecastItem, newItem: HomeForecastItem): Boolean {
        return oldItem.timeStamp == newItem.timeStamp
    }

    override fun areContentsTheSame(oldItem: HomeForecastItem, newItem: HomeForecastItem): Boolean {
        return oldItem.timeStamp == newItem.timeStamp
    }

}