package com.example.mvi.core.usecase

import com.example.mvi.core.result.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import java.lang.Exception

@FlowPreview
@ExperimentalCoroutinesApi
abstract class FlowUseCase<Params : Any, Type : Any>(private val coroutineDispatcher: CoroutineDispatcher) {

//    private val channel = ConflatedBroadcastChannel<Params>()

    operator fun invoke(params: Params): Flow<Result<Type>> =
        execute(params)
            .catch { e -> emit(Result.Failure(Exception(e))) }
            .flowOn(coroutineDispatcher)

    protected abstract fun execute(params: Params): Flow<Result<Type>>


//    override fun observe(): Flow<Type> =
//        channel.asFlow()
//            .distinctUntilChanged()
//            .flatMapLatest {
//                execute(it)
//            }.flowOn(dispatcher)
}