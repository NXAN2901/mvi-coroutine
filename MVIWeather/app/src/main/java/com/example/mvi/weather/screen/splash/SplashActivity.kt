package com.example.mvi.weather.screen.splash

import android.util.Log
import com.example.mvi.weather.BR
import com.example.mvi.weather.R
import com.example.mvi.weather.databinding.ActivitySplashBinding
import com.example.mvi.weather.screen.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels

@AndroidEntryPoint
class SplashActivity: BaseActivity<ActivitySplashBinding, SplashVM>() {

    private val splashVM: SplashVM by viewModels()

    override fun getLayoutId(): Int = R.layout.activity_splash

    override fun getViewModel(): SplashVM {
        return splashVM
    }

    override fun getViewModelVariable(): Int {
        return BR.viewModel
    }

    override fun setUp() {
    }


}