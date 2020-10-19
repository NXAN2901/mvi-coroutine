package com.example.mvi.ui.home

import com.example.mvi.ui.home.models.HomeForecast

data class HomeViewState(
    val isLoading: Boolean,
    val forecastItems: List<HomeForecast>,
    val isRefreshing: Boolean,
    val error: Throwable?
) {
    companion object {
        fun initial(): HomeViewState = HomeViewState(
            isLoading = true,
            forecastItems = ArrayList(),
            isRefreshing = false,
            error = null
        )
    }
}


sealed class HomePartialChange {

    abstract fun reduce(viewState: HomeViewState): HomeViewState

    sealed class GetForecast : HomePartialChange() {
        override fun reduce(viewState: HomeViewState): HomeViewState {
            return when (this) {
                Loading -> viewState.copy(
                    isLoading = true,
                    error = null
                )
                is Data -> viewState.copy(
                    isLoading = false,
                    error = null,
                    forecastItems = forecasts.toMutableList()
                )
                is Error -> viewState.copy(
                    isLoading = false,
                    error = error
                )
            }
        }

        object Loading : GetForecast()
        data class Data(val forecasts: List<HomeForecast>) : GetForecast()
        data class Error(val error: Throwable) : GetForecast()
    }

//    sealed class GetCurrentWeather: HomePartialChange() {
//        override fun reduce(viewState: HomeViewState): HomeViewState {
//            when (this) {
//
//            }
//        }
//
//        object Loading : GetCurrentWeather()
//        data class Data(val currentWeather: HomeForecast) : GetCurrentWeather()
//        data class Error(val error: Throwable) : GetCurrentWeather()
//    }

}