package com.example.mvi.core.usecase

import com.example.mvi.core.result.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class ResultUseCase<Type, in Params> where Type : Any {

    protected abstract val workDispatcher: CoroutineDispatcher

    abstract suspend fun execute(params: Params): Result<Type>

    suspend operator fun invoke(params: Params): Result<Type> = withContext(workDispatcher) {
        execute(params = params)
    }
}