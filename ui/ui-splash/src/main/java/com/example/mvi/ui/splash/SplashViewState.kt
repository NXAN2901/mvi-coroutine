package com.example.mvi.ui.splash

import com.example.mvi.data.datastore.AppPreferences

data class SplashViewState(
    val isLoading: Boolean,
    val tutorialFlag: AppPreferences.AppState?
) {

    companion object {
        fun initial() = SplashViewState(
            isLoading = true,
            tutorialFlag = null
        )
    }
}

sealed class SplashPartialChange {
    abstract fun reduce(viewState: SplashViewState): SplashViewState

    sealed class GetAppState : SplashPartialChange() {
        override fun reduce(viewState: SplashViewState): SplashViewState {
            return when (this) {
                Loading -> viewState.copy(isLoading = true, tutorialFlag = null)
                is Data -> viewState.copy(isLoading = false, tutorialFlag = appState)
            }
        }

        object Loading : GetAppState()
        data class Data(val appState: AppPreferences.AppState) : GetAppState()
    }

}



