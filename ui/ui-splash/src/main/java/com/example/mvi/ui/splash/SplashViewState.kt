package com.example.mvi.ui.splash

import com.example.core.data.datastore.TutorialFlag

data class SplashViewState(
    val isLoading: Boolean,
    val tutorialFlag: TutorialFlag?
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

    sealed class GetTutorialFlag : SplashPartialChange() {
        override fun reduce(viewState: SplashViewState): SplashViewState {
            return when (this) {
                Loading -> viewState.copy(isLoading = true, tutorialFlag = null)
                is Data -> viewState.copy(isLoading = false, tutorialFlag = flag)
            }
        }

        object Loading : GetTutorialFlag()
        data class Data(val flag: TutorialFlag): GetTutorialFlag()
    }

}



