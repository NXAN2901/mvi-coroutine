package com.example.mvi.ui.home.views.forecast.content

import com.example.mvi.ui.home.R
import com.example.mvi.ui.home.databinding.ItemContentWeatherCurrentBinding
import com.example.mvi.ui.home.models.HomeForecast
import kotlin.math.ceil
import kotlin.math.floor

class StatusContentVH(private val binding: ItemContentWeatherCurrentBinding): HomeContentVH(binding) {
    override fun bind(homeForecast: HomeForecast) {
        if (homeForecast !is HomeForecast.CurrentWeather) {
            throw RuntimeException("Expect ${HomeForecast.CurrentWeather::class.simpleName} but received ${homeForecast.javaClass.simpleName}")
        }
        binding.apply {
            tvStatus.text = homeForecast.status
            tvTempDif.text = String.format(
                itemView.context.applicationContext.getString(R.string.home_status_temp_diff),
                floor(homeForecast.tempMin).toInt(),
                ceil(homeForecast.tempMax).toInt()
            )
        }
    }

}