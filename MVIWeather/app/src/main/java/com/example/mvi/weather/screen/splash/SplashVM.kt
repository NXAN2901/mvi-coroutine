package com.example.mvi.weather.screen.splash

import android.app.Application
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import com.example.mvi.weather.screen.base.BaseViewModel

class SplashVM @ViewModelInject constructor(
    application: Application,
    @Assisted private val savedStateHandle: SavedStateHandle
) : BaseViewModel(application) {

}