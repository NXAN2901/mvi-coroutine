package com.example.mvi.core.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

interface ObservableUseCase<Type> {
    val dispatcher: CoroutineDispatcher
    fun observe(): Flow<Type>
}