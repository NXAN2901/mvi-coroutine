package com.example.mvi.ui.home.di

import com.example.mvi.ui.home.viewmodel.HomeVM
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@ExperimentalCoroutinesApi
val homeVMModule = module {
    viewModel { HomeVM(get(), get()) }
}