package com.example.mvi.ui.splash

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.addRepeatingJob
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.mvi.android.core.binding.viewBinding
import com.example.mvi.data.datastore.AppPreferences
import com.example.mvi.ui.base.BaseFragment
import com.example.mvi.ui.splash.databinding.FragmentSplashBinding
import com.example.mvi.ui.splash.viewmodel.SplashVM
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import org.koin.androidx.viewmodel.ext.android.viewModel

@FlowPreview
@ExperimentalCoroutinesApi
class SplashFragment : BaseFragment<FragmentSplashBinding, SplashVM>(R.layout.fragment_splash) {

    private val splashVM: SplashVM by viewModel()
    private val viewIntents = merge(
        flowOf(SplashViewIntent.Initial)
    )

    private val binding by viewBinding(FragmentSplashBinding::bind)

    override fun getViewBinding(): FragmentSplashBinding = binding

    override fun setUpView() {
        setUpEvents()
    }

    private fun setUpEvents() {
        viewLifecycleOwner.addRepeatingJob(Lifecycle.State.STARTED) {
            getViewModel().viewStateChannel.collect { viewState ->
                renderUiByViewState(viewState)
            }
        }

        viewIntents.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .onEach { getViewModel().processIntent(it) }
            .launchIn(lifecycleScope)
    }

    private fun renderUiByViewState(viewState: SplashViewState) {
        binding.run {
            viewState.tutorialFlag?.let { flag ->
                if (flag == AppPreferences.AppState.UNSPECIFIED || flag == AppPreferences.AppState.INITIALIZATION) {
                    findNavController().navigate(R.id.splashToIntro)
                    return
                }
                findNavController().navigate(R.id.splashToHome)
            }
        }
    }

    override fun getViewModel(): SplashVM = splashVM
}