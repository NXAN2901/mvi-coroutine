package com.example.core.data.repos

import com.example.mvi.data.datastore.AppPreferences
import kotlinx.coroutines.flow.Flow

interface AppPreferencesRepo {

    suspend fun setAppState(appState: AppPreferences.AppState)

    fun getAppState(): Flow<AppPreferences.AppState>

}