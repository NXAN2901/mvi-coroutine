package com.example.mvi.ui.intro

import com.example.mvi.android.core.binding.viewBinding
import com.example.mvi.ui.base.BaseFragment
import com.example.mvi.ui.intro.adapter.IntroAdapter
import com.example.mvi.ui.intro.adapter.IntroItem
import com.example.mvi.ui.intro.databinding.FragmentIntroBinding
import com.example.mvi.ui.intro.viewmodel.IntroVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class IntroFragment : BaseFragment<FragmentIntroBinding, IntroVM>(R.layout.fragment_intro) {

    private val introVM: IntroVM by viewModel()

    private val binding by viewBinding(FragmentIntroBinding::bind)

    override fun getViewBinding(): FragmentIntroBinding = binding

    override fun getViewModel(): IntroVM = introVM

    override fun setUpView() {
        val introAdapter = IntroAdapter()
        binding.introPager.adapter = introAdapter
        introAdapter.submitList(
            listOf(
                IntroItem("Intro 1", "Des 1"),
                IntroItem("Intro 2", "Des 2")
            )
        )
    }

}