package com.example.mvi.ui.home

data class HomeViewState(
    val isLoading: Boolean,
    val forecastItems: List<HomeForecastItem>,
    val isRefreshing: Boolean,
    val error: Throwable?
) {
    companion object {
        fun initial(): HomeViewState = HomeViewState(
            isLoading = true,
            forecastItems = emptyList(),
            isRefreshing = false,
            error = null
        )
    }
}

data class HomeForecastItem(
    val city: String
)

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
                    forecastItems = forecasts
                )
                is Error -> viewState.copy(
                    isLoading = false,
                    error = error
                )
            }
        }

        object Loading : GetForecast()
        data class Data(val forecasts: List<HomeForecastItem>): GetForecast()
        data class Error(val error: Throwable): GetForecast()
    }

}