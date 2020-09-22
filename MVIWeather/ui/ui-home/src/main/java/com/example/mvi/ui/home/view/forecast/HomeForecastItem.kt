package com.example.mvi.ui.home.view.forecast

import com.example.mvi.android.core.adapter.ViewBindingAdapterItem

class HomeForecastItem(val timeStamp: Long, val degree: Int) : ViewBindingAdapterItem {

    override val itemViewType: Int
        get() = HOME_STATUS_NORMAL_VIEW_TYPE

    companion object {
        const val HOME_STATUS_NORMAL_VIEW_TYPE = 0
    }
}