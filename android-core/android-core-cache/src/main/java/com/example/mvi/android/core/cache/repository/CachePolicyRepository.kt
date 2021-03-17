package com.example.mvi.android.core.cache.repository

abstract class CachePolicyRepository<T>(
    private val localDataSource: LocalDataSource<String, CacheEntry<T>>,
    private val remoteDataSource: RemoteDataSource<T>
) {

    fun fetch(url: String, cachePolicy: CachePolicy): T? {
        return when (cachePolicy.type) {
            CachePolicy.Type.NEVER -> remoteDataSource.fetch(url)
            CachePolicy.Type.ALWAYS -> localDataSource.get(url)?.value ?: fetchAndCache(url)
            CachePolicy.Type.REFRESH -> fetchAndCache(url)
            CachePolicy.Type.CLEAR -> localDataSource.get(url)?.value.also {
                localDataSource.remove(url)
            }
            CachePolicy.Type.EXPIRES -> {
                localDataSource.get(url)?.let { entry ->
                    if (entry.createdAt + cachePolicy.expire > System.currentTimeMillis()) {
                        entry.value
                    } else {
                        fetchAndCache(url)
                    }
                } ?: fetchAndCache(url)
            }
            else -> null
        }
    }

    private fun fetchAndCache(url: String): T {
        return remoteDataSource.fetch(url).also { result ->
            localDataSource.set(url, CacheEntry(key = url, value = result))
        }
    }
}