package com.example.mvi.coredispatchers.di

import com.example.mvi.coredispatchers.CoroutineDispatchers
import com.example.mvi.coredispatchers.CoroutineDispatchersImpl
import org.koin.dsl.module

val dispatcherModule = module {
    single<CoroutineDispatchers> { CoroutineDispatchersImpl() }
}