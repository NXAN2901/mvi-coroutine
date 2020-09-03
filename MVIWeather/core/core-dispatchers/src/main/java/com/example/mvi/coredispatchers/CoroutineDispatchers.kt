package com.example.mvi.coredispatchers

import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

interface CoroutineDispatchers {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
    val computation: CoroutineDispatcher
}
//data class CoroutineDispatchers constructor(
//    val io: CoroutineDispatcher,
//    val main: CoroutineDispatcher,
//    val computation: CoroutineDispatcher
//)