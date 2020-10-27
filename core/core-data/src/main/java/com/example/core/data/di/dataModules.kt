package com.example.core.data.di

import com.example.core.data.datastore.AppFlagDataStore
import org.koin.dsl.module

val dataModules = module {
    single { AppFlagDataStore(get()) }
}