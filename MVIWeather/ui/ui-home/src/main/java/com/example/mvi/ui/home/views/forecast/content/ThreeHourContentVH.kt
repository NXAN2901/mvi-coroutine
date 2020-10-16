package com.example.mvi.ui.home.views.forecast.content

import android.util.Log
import android.view.View
import com.example.mvi.ui.home.models.HomeForecast
import java.lang.RuntimeException

class ThreeHourContentVH(view: View) : HomeContentVH(view) {

    override fun bind(homeForecast: HomeForecast) {
        if (homeForecast !is HomeForecast.ThreeHour) {
            throw RuntimeException("Expect ${HomeForecast.ThreeHour::class.simpleName} but received ${homeForecast.javaClass.simpleName}")
        }
        Log.e("ANNX", "Bind ThreeHour ${homeForecast.listThreeHourForecast.size}")

        // TODO bind three hour view
    }

}