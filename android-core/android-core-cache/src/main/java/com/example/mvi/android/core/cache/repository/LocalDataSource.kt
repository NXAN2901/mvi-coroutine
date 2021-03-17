package com.example.mvi.android.core.cache.repository

interface LocalDataSource<in Key: Any, T> {

    fun get(key: Key): T?
    fun set(key: Key, value: T)
    fun remove(key: Key)
    fun clear()
}