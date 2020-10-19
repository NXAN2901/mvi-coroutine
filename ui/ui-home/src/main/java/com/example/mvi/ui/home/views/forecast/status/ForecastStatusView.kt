package com.example.mvi.ui.home.views.forecast.status

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mvi.ui.home.R

class ForecastStatusView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val layoutInflater by lazy {
        LayoutInflater.from(context)
    }

    init {
        layoutInflater.inflate(R.layout.item_forecast_status, this, false)
    }



}