package com.example.mvi.ui.home.views.forecast.content

import android.animation.ValueAnimator
import android.util.Log
import androidx.viewbinding.ViewBinding
import com.example.mvi.android.core.adapter.animated.AnimatedItemHolder
import com.example.mvi.ui.home.models.HomeForecast

abstract class HomeContentVH<T : HomeForecast, V : ViewBinding>(vb: V) :
    AnimatedItemHolder<T, V>(vb) {

    private var animator: ValueAnimator? = null
    private var isShown = false

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
        private const val ANIMATION_DURATION = 1500L
    }
}