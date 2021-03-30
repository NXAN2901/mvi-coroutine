package com.example.mvi.ui.home

import android.view.animation.AnimationUtils
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.addRepeatingJob
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
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
import org.koin.androidx.viewmodel.ext.android.viewModel
import reactivecircus.flowbinding.android.view.clicks
import kotlin.math.ceil

@ExperimentalCoroutinesApi
@FlowPreview
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeVM>(R.layout.fragment_home) {

    private val homeVM: HomeVM by viewModel()
    private val binding by viewBinding(FragmentHomeBinding::bind)

    private val viewIntents by lazy {
        merge(
            flowOf(HomeViewIntent.Initial),
            binding.homeContent.header.ivRefresh
                .clicks()
                .map { HomeViewIntent.Refresh }
        )
    }

    override fun getViewBinding(): FragmentHomeBinding = binding

    override fun getViewModel(): HomeVM = homeVM

    override fun setUpView() {
        binding.drawer.setScrimColor(ResourcesCompat.getColor(resources, R.color.transparent, null))
        binding.homeContent.apply {
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
        viewLifecycleOwner.addRepeatingJob(Lifecycle.State.STARTED) {
            getViewModel().viewState.onEach {
                renderUIByViewState(it)
            }.collect()
        }

        viewIntents
            .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
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
                    binding.homeContent.appBar.apply {
                        tvCity.text = currentWeather.name
                        tvDate.text = currentWeather.time.toDateFormat("yyyy-dd-MM")
                        tvTemp.text = String.format(
                            getString(R.string.home_header_current_temp),
                            ceil(currentWeather.currentTemp).toInt()
                        )
                    }
                }
                binding.homeContent.scrollableLayout.rvContent.apply {
                    (adapter as HomeContentAdapter).setDataList(forecasts)
                    scheduleLayoutAnimation()
                }
            }
        }
    }


}