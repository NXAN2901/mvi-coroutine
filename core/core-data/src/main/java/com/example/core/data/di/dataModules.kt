package com.example.core.data.di

import android.app.Application
import com.example.core.data.datastore.AppFlagDataStore
import com.example.core.data.repos.AppPreferencesRepo
import com.example.core.data.repos.AppPreferencesRepoImpl
import com.example.core.data.usecase.GetAppStateUseCase
import com.example.core.data.usecase.UpdateAppStateUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.dsl.module

@FlowPreview
@OptIn(ExperimentalCoroutinesApi::class)
val dataModules = module {
    single { AppFlagDataStore(get()) }
    single<AppPreferencesRepo> { AppPreferencesRepoImpl(get<Application>()) }

    factory { GetAppStateUseCase(get(), get()) }
    factory { UpdateAppStateUseCase(get(), get()) }
}