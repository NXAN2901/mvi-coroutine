package com.example.mvi.ui.intro.views

import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.ViewCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.mvi.ui.intro.R
import kotlin.math.abs

class SliderTransformer(private val offscreenPageLimited: Int) : ViewPager2.PageTransformer {

    override fun transformPage(page: View, position: Float) {
        page.apply {
            val tvIntroHeader = findViewById<AppCompatTextView>(R.id.tvIntroHeader)
            val tvIntroDescription = findViewById<AppCompatTextView>(R.id.tvIntroDescription)
            ViewCompat.setElevation(page, -abs(position))

            val scaleFactor = -SCALE_FACTOR * position + DEFAULT_SCALE
            val alphaFactor = -ALPHA_FACTOR * position + DEFAULT_ALPHA

            alpha = DEFAULT_ALPHA + position
            when {
                position <= 0f -> {
                    translationX = DEFAULT_TRANSLATION_X
                    scaleX = DEFAULT_SCALE
                    scaleY = DEFAULT_SCALE
                    alpha = DEFAULT_ALPHA + position
                    tvIntroHeader.alpha = DEFAULT_ALPHA + position
                    tvIntroDescription.alpha = DEFAULT_ALPHA + position
                }
                position <= offscreenPageLimited - 1 -> {
                    scaleX = scaleFactor
                    scaleY = scaleFactor
                    translationX = -(width / DEFAULT_TRANSLATION_FACTOR) * position
                    alpha = alphaFactor
                    tvIntroHeader.alpha = DEFAULT_ALPHA - position
                    tvIntroDescription.alpha = DEFAULT_ALPHA - position
                }
                else -> {
                    translationX = DEFAULT_TRANSLATION_X
                    scaleX = DEFAULT_SCALE
                    scaleY = DEFAULT_SCALE
                    alpha = DEFAULT_ALPHA
                    tvIntroHeader.alpha = DEFAULT_ALPHA
                    tvIntroDescription.alpha = DEFAULT_ALPHA
                }
            }
        }
    }

    companion object {

        private const val DEFAULT_TRANSLATION_X = .0f
        private const val DEFAULT_TRANSLATION_FACTOR = 1.2f

        private const val SCALE_FACTOR = .24f
        private const val DEFAULT_SCALE = 1f

        private const val ALPHA_FACTOR = .3f
        private const val DEFAULT_ALPHA = 1f
    }
}