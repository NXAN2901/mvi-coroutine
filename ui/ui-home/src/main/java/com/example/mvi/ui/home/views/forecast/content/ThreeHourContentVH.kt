package com.example.mvi.ui.home.views.forecast.content

import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvi.ui.home.R
import com.example.mvi.ui.home.databinding.ItemContentThreehourBinding
import com.example.mvi.ui.home.models.HomeForecast
import com.example.mvi.ui.home.views.forecast.threehour.HomeThreeHourForecastAdapter

class ThreeHourContentVH(binding: ItemContentThreehourBinding) :
    HomeContentVH<HomeForecast, ItemContentThreehourBinding>(binding) {

    override fun bind(item: HomeForecast) {
        if (item !is HomeForecast.ThreeHour) {
            throw RuntimeException("Expect ${HomeForecast.ThreeHour::class.simpleName} but received ${item.javaClass.simpleName}")
        }
        binding.apply {
            rvThreeHour.apply {
                if (adapter == null) {
                    layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    layoutAnimation = AnimationUtils.loadLayoutAnimation(
                        context,
                        R.anim.home_layout_animation_fall_down
                    )
                    adapter = HomeThreeHourForecastAdapter().apply {
                        submitList(item.listThreeHourForecast)
                    }
                    scheduleLayoutAnimation()
                } else {
                    (adapter as HomeThreeHourForecastAdapter).submitList(item.listThreeHourForecast)
                    scheduleLayoutAnimation()
                }
            }
        }
    }

}