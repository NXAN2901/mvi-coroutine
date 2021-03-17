package com.example.mvi.android.core.cache.repository

data class CachePolicy(
    val type: Type? = Type.ALWAYS,
    val expire: Long = 0
) {
    enum class Type {
        NEVER,
        ALWAYS,
        REFRESH,
        CLEAR,
        EXPIRES
    }
}

