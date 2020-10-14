package com.example.core.data.di

import android.content.Context
import androidx.datastore.DataStore
import com.example.core.data.datastore.AppFlagDataStore
import org.koin.dsl.koinApplication
import org.koin.dsl.module

val dataModules = module {
    single { AppFlagDataStore(get()) }
}