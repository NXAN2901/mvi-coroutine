package com.example.mvi.ui.home.views.forecast.threehour

import android.view.ViewGroup
import com.example.core.utility.toDateFormat
import com.example.mvi.android.core.adapter.ViewBindingAdapter
import com.example.mvi.android.core.adapter.ViewBindingHolder
import com.example.mvi.ui.home.R
import com.example.mvi.ui.home.databinding.ViewHomeForecastThreeHourBinding
import com.example.mvi.ui.home.models.HomeForecast
import kotlin.math.ceil
import kotlin.math.floor

class HomeThreeHourForecastAdapter :
    ViewBindingAdapter<HomeForecast.HomeThreeHourForecast, ViewHomeForecastThreeHourBinding>(
        ForecastDiffCallback
    ) {
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
        binding.apply {
            tvForecastTempDif.text = String.format(
                itemView.context.getString(R.string.home_threehour_temp_diff),
                floor(item.forecastInfo.tempMin).toInt(),
                ceil(item.forecastInfo.tempMax).toInt()
            )

            tvTime.text = item.time.toDateFormat("HH:00")
        }
    }
}

enum class ThreeHourForecastViewType {
    THREE_HOUR
}