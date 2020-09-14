package com.example.mvi.ui.splash.di

import com.example.mvi.ui.splash.viewmodel.SplashVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashVMModule = module {
    viewModel {
        SplashVM(get())
    }
}