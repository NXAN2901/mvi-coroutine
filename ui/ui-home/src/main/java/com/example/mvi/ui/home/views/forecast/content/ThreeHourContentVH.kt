package com.example.mvi.ui.home.views.forecast.content

import android.animation.ValueAnimator
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvi.ui.home.R
import com.example.mvi.ui.home.databinding.ItemContentThreehourBinding
import com.example.mvi.ui.home.models.HomeForecast
import com.example.mvi.ui.home.views.forecast.threehour.HomeThreeHourForecastAdapter

class ThreeHourContentVH(binding: ItemContentThreehourBinding) :
    HomeContentVH<HomeForecast, ItemContentThreehourBinding>(binding) {

    private var animator: ValueAnimator? = null
    private var isShown = false

    override fun bind(item: HomeForecast) {
        if (item !is HomeForecast.ThreeHour) {
            throw RuntimeException("Expect ${HomeForecast.ThreeHour::class.simpleName} but received ${item.javaClass.simpleName}")
        }
        binding.apply {
            rvThreeHour.apply {
                if (adapter == null) {
                    layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    adapter = HomeThreeHourForecastAdapter().apply {
                        submitList(item.listThreeHourForecast)
                    }
                    layoutAnimation = AnimationUtils.loadLayoutAnimation(
                        context,
                        R.anim.home_layout_animation_fall_down
                    )
                    scheduleLayoutAnimation()
                } else {
                    (adapter as HomeThreeHourForecastAdapter).submitList(item.listThreeHourForecast)
                }
            }
        }
    }

    private fun startShowAnimation() {
        if (!isShown) {
            isShown = true
            animator?.cancel()
            animator = ValueAnimator.ofFloat(itemView.alpha, 1f).apply {
                addUpdateListener {
                    itemView.alpha = it.animatedValue as Float
                }
                duration = ANIMATION_DURATION
                start()
            }
        }
    }

    private fun startExitAnimation() {
        if (isShown) {
            isShown = false
            animator?.cancel()
            animator = ValueAnimator.ofFloat(itemView.alpha, 0f).apply {
                addUpdateListener {
                    itemView.alpha = it.animatedValue as Float
                }
                duration = ANIMATION_DURATION
                start()
            }
        }
    }

    override fun onEnterFromTop() {
        startShowAnimation()
    }

    override fun onExitToTop() {
        startExitAnimation()
    }

    override fun onEnterFromBottom() {
        startShowAnimation()
    }

    override fun onExitToBottom() {
        startExitAnimation()
    }

    companion object {
        private const val ANIMATION_DURATION = 300L
    }

}