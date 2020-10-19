package com.example.mvi.ui.intro.di

import com.example.mvi.ui.intro.viewmodel.IntroVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val introVMModule = module {
    viewModel {
        IntroVM(get())
    }
}