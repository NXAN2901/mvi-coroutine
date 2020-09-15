package com.example.mvi.ui.intro

import android.animation.Animator
import android.animation.ObjectAnimator
import android.util.Log
import android.view.View
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
import org.koin.androidx.viewmodel.ext.android.viewModel

class IntroFragment : BaseFragment<FragmentIntroBinding, IntroVM>(R.layout.fragment_intro) {

    private val onPageChanged = object: ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            if (position == 2) {
                binding.btnDone.visibility = View.VISIBLE
            } else {
                binding.btnDone.visibility = View.GONE
            }
        }
    }
    private val introVM: IntroVM by viewModel()

    private val binding by viewBinding(FragmentIntroBinding::bind)

    override fun getViewBinding(): FragmentIntroBinding = binding

    override fun getViewModel(): IntroVM = introVM

    override fun setUpView() {
        val introAdapter = IntroAdapter()
        binding.introPager.apply {
            adapter = introAdapter
            offscreenPageLimit = 4
            setPageTransformer(SliderTransformer(4))
            // Workaround for remove over scroll animation
            (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            registerOnPageChangeCallback(onPageChanged)
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

    override fun onDetach() {
        binding.introPager.unregisterOnPageChangeCallback(onPageChanged)
        super.onDetach()
    }

}