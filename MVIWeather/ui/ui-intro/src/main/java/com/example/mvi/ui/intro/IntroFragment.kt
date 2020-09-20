package com.example.mvi.ui.intro

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.*
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.mvi.android.core.binding.viewBinding
import com.example.mvi.ui.base.BaseFragment
import com.example.mvi.ui.intro.adapter.IntroAdapter
import com.example.mvi.ui.intro.adapter.IntroItem
import com.example.mvi.ui.intro.databinding.FragmentIntroBinding
import com.example.mvi.ui.intro.viewmodel.IntroVM
import com.example.mvi.ui.intro.views.SliderTransformer
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import reactivecircus.flowbinding.android.view.clicks
import reactivecircus.flowbinding.viewpager2.pageSelections

@FlowPreview
class IntroFragment : BaseFragment<FragmentIntroBinding, IntroVM>(R.layout.fragment_intro),
    LifecycleObserver {

    private val introVM: IntroVM by viewModel()

    private val binding by viewBinding(FragmentIntroBinding::bind)

    override fun getViewBinding(): FragmentIntroBinding = binding

    override fun getViewModel(): IntroVM = introVM

    override fun setUpView() {
        binding.btnDone.executeIntroDone(lifecycleScope) {
            findNavController().navigate(R.id.introToHome)
        }
        binding.tvSkip.executeIntroDone(lifecycleScope) {
            findNavController().navigate(R.id.introToHome)
        }
        val introAdapter = IntroAdapter()
        binding.introPager.apply {
            adapter = introAdapter
            offscreenPageLimit = 3
            setPageTransformer(SliderTransformer(3))
            // Workaround for remove over scroll animation
            (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            pageSelections()
                .onEach { position ->
                    if (position == 2) {
                        binding.btnDone.visibility = View.VISIBLE
                    } else {
                        binding.btnDone.visibility = View.GONE
                    }
                }
                .launchIn(lifecycleScope)
        }
        TabLayoutMediator(binding.introTabLayout, binding.introPager) { _, _ -> Unit }.attach()
        introAdapter.submitList(
            listOf(
                IntroItem("Intro 1", "Des 1"),
                IntroItem("Intro 2", "Des 2"),
                IntroItem("Intro 3", "Des 3")
            )
        )
    }

}

fun View.executeIntroDone(scope: LifecycleCoroutineScope, action: () -> Unit) =
    this.clicks().onEach { action.invoke() }.launchIn(scope)