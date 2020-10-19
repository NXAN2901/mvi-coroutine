package com.example.mvi.ui.home.views.forecast.content

import android.util.Log
import androidx.viewbinding.ViewBinding
import com.example.mvi.ui.home.models.HomeForecast

class StatusContentVH(binding: ViewBinding): HomeContentVH(binding) {
    override fun bind(homeForecast: HomeForecast) {
        if (homeForecast !is HomeForecast.CurrentWeather) {
            throw RuntimeException("Expect ${HomeForecast.CurrentWeather::class.simpleName} but received ${homeForecast.javaClass.simpleName}")
        }
        Log.e("ANNX", "bind current weather $homeForecast")
    }

}