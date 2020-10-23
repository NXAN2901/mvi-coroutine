package com.example.mvi.core.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class NoResultUseCase<in Params>(protected val dispatcher: CoroutineDispatcher) {
    abstract suspend fun execute(params: Params)
    suspend operator fun invoke(params: Params) = withContext(dispatcher) {
        execute(params)
    }
}