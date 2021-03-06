package com.example.mvi.ui.home.views.forecast.content

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mvi.android.core.adapter.animated.AnimatedAdapter
import com.example.mvi.ui.home.databinding.ItemContentThreehourBinding
import com.example.mvi.ui.home.databinding.ItemContentWeatherCurrentBinding
import com.example.mvi.ui.home.models.HomeForecast
import java.lang.RuntimeException

class HomeContentAdapter(
    private var dataList: List<HomeForecast>
) : AnimatedAdapter<HomeContentVH<HomeForecast, *>>() {

    fun setDataList(list: List<HomeForecast>) {
        dataList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeContentVH<HomeForecast, *> {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            HomeForecastItemViewType.THREE_HOUR.ordinal -> ThreeHourContentVH(
                ItemContentThreehourBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
            HomeForecastItemViewType.STATUS.ordinal -> StatusContentVH(
                ItemContentWeatherCurrentBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
            else -> throw RuntimeException("Not Support ${HomeForecastItemViewType.values()[viewType]} yet!!!")
        }
    }

    override fun onBindViewHolder(holder: HomeContentVH<HomeForecast, *>, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    override fun getItemViewType(position: Int): Int {
        return dataList[position].itemViewType
    }
}

enum class HomeForecastItemViewType {
    THREE_HOUR,
    STATUS
}
