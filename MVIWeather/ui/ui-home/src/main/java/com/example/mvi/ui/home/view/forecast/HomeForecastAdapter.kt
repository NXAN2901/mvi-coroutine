package com.example.mvi.ui.home.view.forecast

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvi.android.core.adapter.ViewBindingAdapter
import com.example.mvi.android.core.adapter.ViewBindingHolder
import com.example.mvi.ui.home.R
import com.example.mvi.ui.home.databinding.ViewHomeForecastBinding

class HomeForecastAdapter :
    ViewBindingAdapter<HomeForecastItem, ViewHomeForecastBinding>(ForecastDiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewBindingHolder<HomeForecastItem, ViewHomeForecastBinding> {
        return HomeForecastVH(
            ViewHomeForecastBinding.inflate(
                parent.layoutInflater,
                parent,
                false
            ).apply {
                root.maxWidth = parent.measuredWidth / 3
            }
        )
    }

}

class HomeForecastVH(binding: ViewHomeForecastBinding) :
    ViewBindingHolder<HomeForecastItem, ViewHomeForecastBinding>(binding) {
    override fun bind(item: HomeForecastItem) {
        Log.e("ANNX", "Bind")
    }

}