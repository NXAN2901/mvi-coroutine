package com.example.mvi.ui.home.di

import com.example.mvi.ui.home.viewmodel.HomeVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeVMModule = module {
    viewModel { HomeVM(get(), get()) }
}