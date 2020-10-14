package com.example.mvi.ui.splash.di

import com.example.mvi.ui.splash.viewmodel.SplashVM
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@ExperimentalCoroutinesApi
@FlowPreview
val splashVMModule = module {
    viewModel {
        SplashVM(get(), get())
    }
}