package com.example.mvi.ui.home

import android.view.animation.AnimationUtils
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.data.datastore.AppFlagDataStore
import com.example.core.data.datastore.TutorialFlag
import com.example.core.utility.toDateFormat
import com.example.mvi.android.core.binding.viewBinding
import com.example.mvi.ui.base.BaseFragment
import com.example.mvi.ui.home.databinding.FragmentHomeBinding
import com.example.mvi.ui.home.models.HomeForecast
import com.example.mvi.ui.home.viewmodel.HomeVM
import com.example.mvi.ui.home.views.forecast.content.HomeContentAdapter
import kotlinx.android.synthetic.main.home_header_layout.view.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import reactivecircus.flowbinding.android.view.clicks
import kotlin.math.ceil

@ExperimentalCoroutinesApi
@FlowPreview
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeVM>(R.layout.fragment_home) {

    private val homeVM: HomeVM by viewModel()
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val appFlagDataStore: AppFlagDataStore by inject()

    private val viewIntents by lazy {
        merge(
            flowOf(HomeViewIntent.Initial),
            binding.header.ivRefresh
                .clicks()
                .map { HomeViewIntent.Refresh }
        )
    }

    override fun getViewBinding(): FragmentHomeBinding = binding

    override fun getViewModel(): HomeVM = homeVM

    override fun setUpView() {
        binding.apply {
            scrollableLayout.rvContent.apply {
                adapter = HomeContentAdapter(emptyList())
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                layoutAnimation = AnimationUtils.loadLayoutAnimation(
                    context,
                    R.anim.home_layout_animation_fall_down
                )
                scheduleLayoutAnimation()
            }
        }
        setUpEvent()
    }

    private fun setUpEvent() {
        lifecycleScope.launchWhenCreated {
            appFlagDataStore.setTutorialFlag(TutorialFlag.PASSED)
        }

        lifecycleScope.launchWhenStarted {
            getViewModel().viewState.onEach {
                renderUIByViewState(it)
            }.collect()
        }

        viewIntents
            .onEach {
                getViewModel().processIntent(it)
            }
            .launchIn(lifecycleScope)
    }

    private fun renderUIByViewState(viewState: HomeViewState) {
        binding.apply {
            viewState.forecastItems.let { forecasts ->
                if (forecasts.isNotEmpty() && forecasts[0] is HomeForecast.CurrentWeather) {
                    val currentWeather = forecasts[0] as HomeForecast.CurrentWeather
                    appBar.tvCity.text = currentWeather.name
                    appBar.tvDate.text = currentWeather.time.toDateFormat("yyyy-dd-MM")
                    appBar.tvTemp.text = String.format(
                        getString(R.string.home_header_current_temp),
                        ceil(currentWeather.currentTemp).toInt()
                    )
                }
                (scrollableLayout.rvContent.adapter as HomeContentAdapter).setDataList(forecasts)
            }
        }
    }


}