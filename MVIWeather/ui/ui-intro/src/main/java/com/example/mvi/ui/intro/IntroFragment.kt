package com.example.mvi.ui.intro

import androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL
import com.example.mvi.ui.intro.adapter.IntroAdapter
import com.example.mvi.ui.intro.adapter.IntroItem
import com.example.mvi.ui.base.BaseFragment
import com.example.mvi.ui.base.viewBinding
import com.example.mvi.ui.intro.databinding.FragmentIntroBinding

class IntroFragment : BaseFragment<FragmentIntroBinding>(R.layout.fragment_intro) {

    private val binding by viewBinding(FragmentIntroBinding::inflate)

    override fun initView() {
        binding.introPager.apply {
            orientation = ORIENTATION_HORIZONTAL
            adapter = IntroAdapter().apply {
                submitList(listOf(
                    IntroItem("Intro 1", "Des 1"),
                    IntroItem("Intro 2", "Des 2")
                ))
            }
        }
    }

    override fun getViewBinding(): FragmentIntroBinding = binding

}