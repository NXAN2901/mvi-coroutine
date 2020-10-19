package com.example.mvi.android.core.datastore

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.createDataStore

abstract class BaseDataStore(context: Context) {

    abstract fun getName(): String

    protected val dataStore: DataStore<Preferences> by lazy {
        context.createDataStore(name = getName())
    }
}