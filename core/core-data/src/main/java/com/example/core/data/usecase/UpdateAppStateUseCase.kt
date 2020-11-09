package com.example.core.data.usecase

import com.example.core.data.repos.AppPreferencesRepo
import com.example.mvi.core.usecase.NoResultUseCase
import com.example.mvi.coredispatchers.CoroutineDispatchers
import com.example.mvi.data.datastore.AppPreferences

class UpdateAppStateUseCase(
    appDispatchers: CoroutineDispatchers,
    private val appPreferencesRepo: AppPreferencesRepo,
) : NoResultUseCase<UpdateAppStateUseCase.Params>(appDispatchers.io) {

    data class Params(val appState: AppPreferences.AppState)

    override suspend fun execute(params: Params) = appPreferencesRepo.setAppState(params.appState)
}
