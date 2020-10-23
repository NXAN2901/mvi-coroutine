package com.example.mvi.ui.home.di

import com.example.mvi.ui.home.viewmodel.HomeVM
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@FlowPreview
@ExperimentalCoroutinesApi
val homeVMModule = module {
    viewModel { HomeVM(get(), get(), get(), get()) }
}