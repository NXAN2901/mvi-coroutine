package com.example.mvi.ui.home

sealed class HomeViewIntent {
    object Initial: HomeViewIntent()
    object Retry: HomeViewIntent()
    object Refresh : HomeViewIntent()
    data class FetchForecasts(val city: String): HomeViewIntent()
}