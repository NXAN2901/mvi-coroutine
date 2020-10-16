package com.example.mvi.ui.home.views.forecast.threehour

import com.example.mvi.android.core.adapter.ViewBindingAdapterItem

class HomeThreeHourForecastItem(val timeStamp: Long, val temperature: Int) : ViewBindingAdapterItem {

    override val itemViewType: Int
        get() = HOME_STATUS_NORMAL_VIEW_TYPE

    companion object {
        const val HOME_STATUS_NORMAL_VIEW_TYPE = 0
    }
}