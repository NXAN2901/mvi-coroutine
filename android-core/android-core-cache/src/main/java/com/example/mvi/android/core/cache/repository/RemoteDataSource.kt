package com.example.mvi.android.core.cache.repository

interface RemoteDataSource<T> {
    fun fetch(url: String): T
}