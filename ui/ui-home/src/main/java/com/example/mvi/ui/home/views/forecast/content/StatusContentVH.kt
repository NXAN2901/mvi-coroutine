package com.example.mvi.ui.home.views.forecast.content

import android.animation.ValueAnimator
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mvi.ui.home.R
import com.example.mvi.ui.home.databinding.ItemContentWeatherCurrentBinding
import com.example.mvi.ui.home.models.HomeForecast
import kotlin.math.ceil
import kotlin.math.floor

class StatusContentVH(binding: ItemContentWeatherCurrentBinding): HomeContentVH<HomeForecast, ItemContentWeatherCurrentBinding>(binding) {

    private var animator: ValueAnimator? = null
    private var isShown = false

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