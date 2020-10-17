package com.example.mvi.ui.home.views.forecast.content

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvi.ui.home.databinding.ItemContentThreehourBinding
import com.example.mvi.ui.home.models.HomeForecast
import com.example.mvi.ui.home.views.forecast.threehour.HomeThreeHourForecastAdapter
import java.lang.RuntimeException

class ThreeHourContentVH(private val binding: ItemContentThreehourBinding) : HomeContentVH(binding) {

    override fun bind(homeForecast: HomeForecast) {
        if (homeForecast !is HomeForecast.ThreeHour) {
            throw RuntimeException("Expect ${HomeForecast.ThreeHour::class.simpleName} but received ${homeForecast.javaClass.simpleName}")
        }
        Log.e("ANNX", "Bind ThreeHour ${homeForecast.listThreeHourForecast.size}")
        binding.apply {
            rvThreeHour.apply {
                if (adapter == null) {
                    adapter = HomeThreeHourForecastAdapter().apply {
                        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                        submitList(homeForecast.listThreeHourForecast)
                    }
                }
            }
        }
    }

}