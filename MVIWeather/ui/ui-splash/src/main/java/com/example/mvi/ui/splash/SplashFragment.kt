package com.example.mvi.ui.splash

import com.example.mvi.ui.base.BaseFragment
import com.example.mvi.ui.base.viewBinding
import com.example.mvi.ui.splash.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {

    private val binding by viewBinding(FragmentSplashBinding::inflate)

    override fun initView() {
    }

    override fun getViewBinding(): FragmentSplashBinding = binding
}