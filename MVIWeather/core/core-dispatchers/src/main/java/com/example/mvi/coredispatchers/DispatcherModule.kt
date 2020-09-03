package com.example.mvi.coredispatchers

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class DispatcherModule {

    @Binds
    abstract fun bindCoroutineDispatcher(coroutineDispatchersImpl: CoroutineDispatchersImpl): CoroutineDispatchers

}