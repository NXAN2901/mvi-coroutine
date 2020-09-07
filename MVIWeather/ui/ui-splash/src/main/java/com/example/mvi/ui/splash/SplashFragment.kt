package com.example.mvi.ui.splash

import android.util.Log
import com.example.mvi.ui.base.BaseFragment
import com.example.mvi.ui.base.viewBinding
import com.example.mvi.ui.splash.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {

    private val binding by viewBinding(FragmentSplashBinding::bind)

    override fun initView() {
    }

    override fun getViewBinding(): FragmentSplashBinding = binding
}