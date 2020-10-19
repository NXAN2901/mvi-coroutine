package com.example.mvi.ui.home.views.forecast.content

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.mvi.ui.home.databinding.ItemContentThreehourBinding
import com.example.mvi.ui.home.databinding.ItemContentWeatherCurrentBinding
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

    override fun onBindViewHolder(holder: HomeContentVH, position: Int) {
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

abstract class HomeContentVH(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(homeForecast: HomeForecast)
}