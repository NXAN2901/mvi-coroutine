package com.example.mvi.ui.home

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.data.datastore.AppFlagDataStore
import com.example.core.data.datastore.TutorialFlag
import com.example.mvi.android.core.binding.viewBinding
import com.example.mvi.ui.base.BaseFragment
import com.example.mvi.ui.home.databinding.FragmentHomeBinding
import com.example.mvi.ui.home.viewmodel.HomeVM
import com.example.mvi.ui.home.views.forecast.content.HomeContentAdapter
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

@ExperimentalCoroutinesApi
@FlowPreview
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeVM>(R.layout.fragment_home) {

    private val homeVM: HomeVM by viewModel()
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val appFlagDataStore: AppFlagDataStore by inject()

    private val viewIntents = merge(
        flowOf(HomeViewIntent.Initial)
    )

    override fun getViewBinding(): FragmentHomeBinding = binding

    override fun getViewModel(): HomeVM = homeVM

    override fun setUpView() {
//        binding.appBar.offsetChanges().onEach { verticalOffset ->
//            val progress = -verticalOffset / binding.appBar.totalScrollRange.toFloat()
//            binding.scrollableLayout.scrollableContent.progress = progress
//        }.launchIn(lifecycleScope)
        binding.apply {
            scrollableLayout.rvContent.apply {
                adapter = HomeContentAdapter(emptyList())
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
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
            viewState.forecastItems.let { forecast ->
                (scrollableLayout.rvContent.adapter as HomeContentAdapter).setDataList(forecast)
            }
        }
    }


}