package com.example.core.data.datastore

import android.content.Context
import androidx.datastore.preferences.edit
import com.example.mvi.android.core.datastore.BaseDataStore
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

enum class TutorialFlag {
    PASSED,
    NOT_PASSED
}

class AppFlagDataStore(context: Context) : BaseDataStore(context.applicationContext) {
    override fun getName(): String = "app_flags"

    val tutorialFlagFlow: Flow<TutorialFlag> = dataStore.data
        .map { preferences ->
            val ordinal = preferences[TUTORIAL_FLAG] ?: TutorialFlag.NOT_PASSED.ordinal
            TutorialFlag.values()[ordinal]
        }

    suspend fun setTutorialFlag(flag: TutorialFlag) {
        dataStore.edit { preferences ->
            preferences[TUTORIAL_FLAG] = flag.ordinal
        }
    }

    companion object {
        val TUTORIAL_FLAG = preferencesKey<Int>("tutorial_flag")
    }

}