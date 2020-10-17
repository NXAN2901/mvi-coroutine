package com.example.mvi.ui.home.views.forecast.threehour

import android.util.Log
import android.view.ViewGroup
import com.example.mvi.android.core.adapter.ViewBindingAdapter
import com.example.mvi.android.core.adapter.ViewBindingHolder
import com.example.mvi.ui.home.databinding.ViewHomeForecastThreeHourBinding
import com.example.mvi.ui.home.models.HomeForecast

class HomeThreeHourForecastAdapter :
    ViewBindingAdapter<HomeForecast.HomeThreeHourForecast, ViewHomeForecastThreeHourBinding>(ForecastDiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewBindingHolder<HomeForecast.HomeThreeHourForecast, ViewHomeForecastThreeHourBinding> {
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
    ViewBindingHolder<HomeForecast.HomeThreeHourForecast, ViewHomeForecastThreeHourBinding>(binding) {
    override fun bind(item: HomeForecast.HomeThreeHourForecast) {
        Log.e("ANNX", "Bind")
    }

}

enum class ThreeHourForecastViewType {
    THREE_HOUR
}