package com.example.mvi.ui.home.views.forecast.content

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mvi.ui.home.R
import com.example.mvi.ui.home.databinding.ItemContentWeatherCurrentBinding
import com.example.mvi.ui.home.models.HomeForecast
import kotlin.math.ceil
import kotlin.math.floor

class StatusContentVH(binding: ItemContentWeatherCurrentBinding): HomeContentVH<HomeForecast, ItemContentWeatherCurrentBinding>(binding) {

    override fun bind(item: HomeForecast) {
        if (item !is HomeForecast.CurrentWeather) {
            throw RuntimeException("Expect ${HomeForecast.CurrentWeather::class.simpleName} but received ${item.javaClass.simpleName}")
        }
        binding.apply {
            val context = itemView.context
            tvStatus.text = item.status
            tvTempDif.text = String.format(
                itemView.context.applicationContext.getString(R.string.home_status_current_temp_diff),
                floor(item.tempMin).toInt(),
                ceil(item.tempMax).toInt()
            )
            Glide.with(context)
                .load("http://openweathermap.org/img/w/${item.iconName}.png")
                .apply(RequestOptions().override(context.resources.getDimensionPixelSize(R.dimen.home_threehour_icon_size)))
                .into(ivCurrentStatus)
        }
    }
}