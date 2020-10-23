package com.example.mvi.core.usecase

import com.example.mvi.core.result.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class ResultUseCase<Type, in Params>(protected val workDispatcher: CoroutineDispatcher) where Type : Any {

    abstract suspend fun run(params: Params): Result<Type>

    suspend operator fun invoke(params: Params): Result<Type> = withContext(workDispatcher) {
        run(params = params)
    }
}