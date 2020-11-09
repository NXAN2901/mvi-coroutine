package com.example.core.data.repos

import android.content.Context
import android.util.Log
import androidx.datastore.DataStore
import androidx.datastore.createDataStore
import com.example.core.data.datastore.AppPrefsSerializer
import com.example.mvi.data.datastore.AppPreferences
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import java.io.IOException

@ExperimentalCoroutinesApi
class AppPreferencesRepoImpl(context: Context) : AppPreferencesRepo {

    private val _appStateFlow = MutableStateFlow(AppPreferences.AppState.UNSPECIFIED)

    private val appPrefsDataStore: DataStore<AppPreferences> by lazy {
        context.createDataStore(
            fileName = "app_prefs.pb",
            serializer = AppPrefsSerializer
        )
    }

    private val appPreferenceFlow = appPrefsDataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(AppPreferences.getDefaultInstance())
            } else {
                throw exception
            }
        }


    override suspend fun setAppState(appState: AppPreferences.AppState) {
        appPrefsDataStore.updateData { prefs ->
            prefs.toBuilder().setCurrentState(appState).build()
        }
    }

    override fun getAppState(): Flow<AppPreferences.AppState> = flow {
        appPreferenceFlow.onEach {
            Log.e("ANNX", "AppState Gotten ${it.currentState}")
            emit(it.currentState)
        }.collect()
    }

}