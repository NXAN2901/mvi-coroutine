package com.example.mvi.ui.home

import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvi.android.core.binding.viewBinding
import com.example.mvi.ui.base.BaseFragment
import com.example.mvi.ui.home.databinding.FragmentHomeBinding
import com.example.mvi.ui.home.view.forecast.HomeForecastAdapter
import com.example.mvi.ui.home.view.forecast.HomeForecastItem
import com.example.mvi.ui.home.view.forecast.SpanningLinearLayoutManager
import com.example.mvi.ui.home.viewmodel.HomeVM
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import reactivecircus.flowbinding.material.offsetChanges

@ExperimentalCoroutinesApi
@FlowPreview
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeVM>(R.layout.fragment_home) {

    private val homeVM: HomeVM by viewModel()
    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun getViewBinding(): FragmentHomeBinding = binding

    override fun getViewModel(): HomeVM = homeVM

    override fun setUpView() {
        binding.appBar.offsetChanges().onEach { verticalOffset ->
            val progress = -verticalOffset / binding.appBar.totalScrollRange.toFloat()
            binding.scrollableLayout.scrollableContent.progress = progress
        }.launchIn(lifecycleScope)

        binding.scrollableLayout.rvHomeForecast.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = HomeForecastAdapter()
        }

        (binding.scrollableLayout.rvHomeForecast.adapter as HomeForecastAdapter).submitList(
            listOf(
                HomeForecastItem(System.currentTimeMillis(), 15),
                HomeForecastItem(System.currentTimeMillis(), 25),
                HomeForecastItem(System.currentTimeMillis(), 30)
            )
        )

        getViewModel().uiEvents.observe(viewLifecycleOwner, Observer {
            renderUIEvent(it)
        })

        lifecycleScope.launchWhenCreated {
            getViewModel().processIntent(HomeViewIntent.FetchForecasts("Thanh pho Ho Chi Minh,vn"))
        }
    }

    private fun renderUIEvent(event: HomeUIEvent) {
        Log.e("ANNX", "renderUIEvent $event")
        when (event) {
            is HomeUIEvent.Forecasts -> Log.e("ANNX", "Forecast gotten ${event.data}")
        }
    }

}