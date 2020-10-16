package com.example.mvi.ui.home.views.forecast.threehour

import android.util.Log
import android.view.ViewGroup
import com.example.mvi.android.core.adapter.ViewBindingAdapter
import com.example.mvi.android.core.adapter.ViewBindingHolder
import com.example.mvi.ui.home.databinding.ViewHomeForecastThreeHourBinding

class HomeThreeHourForecastAdapter :
    ViewBindingAdapter<HomeThreeHourForecastItem, ViewHomeForecastThreeHourBinding>(ForecastDiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewBindingHolder<HomeThreeHourForecastItem, ViewHomeForecastThreeHourBinding> {
        return HomeForecastVH(
            ViewHomeForecastThreeHourBinding.inflate(
                parent.layoutInflater,
                parent,
                false
            ).apply {
                root.maxWidth = parent.measuredWidth / 3
            }
        )
    }

}

class HomeForecastVH(binding: ViewHomeForecastThreeHourBinding) :
    ViewBindingHolder<HomeThreeHourForecastItem, ViewHomeForecastThreeHourBinding>(binding) {
    override fun bind(item: HomeThreeHourForecastItem) {
        Log.e("ANNX", "Bind")
    }

}