package com.example.mvi.ui.splash

import com.example.mvi.android.core.binding.BaseFragment
import com.example.mvi.android.core.binding.viewBinding
import com.example.mvi.ui.splash.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {

    private val binding by viewBinding(FragmentSplashBinding::bind)

    override fun initView() {

    }

    override fun getViewBinding(): FragmentSplashBinding = binding

}