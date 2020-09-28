package com.example.mvi.core.usecase

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.channels.sendBlocking
import kotlinx.coroutines.flow.*

@FlowPreview
@ExperimentalCoroutinesApi
abstract class FlowUseCase<Type : Any, Params : Any> : ObservableUseCase<Type> {

    private val channel = ConflatedBroadcastChannel<Params>()

    operator fun invoke(params: Params) = channel.sendBlocking(params)

    protected abstract fun execute(params: Params): Flow<Type>

    fun produce(params: Params): Flow<Type> = execute(params = params)

    override fun observe(): Flow<Type> =
        channel.asFlow()
            .distinctUntilChanged()
            .flatMapLatest {
                execute(it)
            }.flowOn(dispatcher)
}