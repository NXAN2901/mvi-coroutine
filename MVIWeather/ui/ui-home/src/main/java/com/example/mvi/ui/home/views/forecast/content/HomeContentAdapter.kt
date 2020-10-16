package com.example.mvi.ui.home.views.forecast.content

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavType
import androidx.recyclerview.widget.RecyclerView
import com.example.mvi.ui.home.R
import com.example.mvi.ui.home.models.HomeForecast
import java.lang.RuntimeException

class HomeContentAdapter(
    private var dataList: List<HomeForecast>
) : RecyclerView.Adapter<HomeContentVH>() {

    fun setDataList(list: List<HomeForecast>) {
        dataList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeContentVH {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            HomeForecastItemViewType.THREE_HOUR.ordinal -> ThreeHourContentVH(
                inflater.inflate(R.layout.item_content_threehour, parent, false)
            )
            HomeForecastItemViewType.STATUS.ordinal -> StatusContentVH(
                inflater.inflate(R.layout.item_content_weather_current, parent, false)
            )
            else -> throw RuntimeException("Not Support ${HomeForecastItemViewType.values()[viewType]} yet!!!")
        }
    }

    override fun onBindViewHolder(holder: HomeContentVH, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    override fun getItemViewType(position: Int): Int {
        return when (dataList[position]) {
            is HomeForecast.ThreeHour -> HomeForecastItemViewType.THREE_HOUR.ordinal
            is HomeForecast.CurrentWeather -> HomeForecastItemViewType.STATUS.ordinal
        }
    }
}

enum class HomeForecastItemViewType {
    THREE_HOUR,
    STATUS
}

abstract class HomeContentVH(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(homeForecast: HomeForecast)
}