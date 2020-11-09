package com.example.core.data.usecase

import com.example.core.data.repos.AppPreferencesRepo
import com.example.mvi.core.result.Result
import com.example.mvi.core.usecase.FlowUseCase
import com.example.mvi.coredispatchers.CoroutineDispatchers
import com.example.mvi.data.datastore.AppPreferences
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*

@ExperimentalCoroutinesApi
@FlowPreview
class GetAppStateUseCase(
    coroutineDispatchers: CoroutineDispatchers,
    private val appPreferencesRepo: AppPreferencesRepo
) : FlowUseCase<Unit, AppPreferences.AppState>(coroutineDispatchers.io) {
    override fun execute(params: Unit): Flow<Result<AppPreferences.AppState>> = flow {
        appPreferencesRepo.getAppState()
            .onEach { emit(Result.Success(it)) }
            .catch { emit(Result.Failure(it)) }
            .collect()
    }

}