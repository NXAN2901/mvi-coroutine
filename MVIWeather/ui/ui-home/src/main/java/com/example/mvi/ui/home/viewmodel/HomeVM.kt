package com.example.mvi.ui.home.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mvi.core.result.Success
import com.example.mvi.ui.base.BaseViewModel
import com.example.mvi.ui.home.HomeUIEvent
import com.example.mvi.ui.home.HomeViewIntent
import com.example.mvi.usecase.weather.FetchForecastUseCase
import com.example.mvi.weather.remoterepo.weather.model.forecast.ForecastDomainModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*

@FlowPreview
@ExperimentalCoroutinesApi
class HomeVM(application: Application, private val fetchForecastUseCase: FetchForecastUseCase) :
    BaseViewModel(application) {

    private val _intentChannel = ConflatedBroadcastChannel<HomeViewIntent>()
    private val _uiEvents = MutableLiveData<HomeUIEvent>()

    val uiEvents: LiveData<HomeUIEvent>
        get() = _uiEvents

    init {
        _intentChannel.asFlow()
            .distinctUntilChanged()
            .onEach { homeViewIntent ->
                when (homeViewIntent) {
                    is HomeViewIntent.FetchForecasts -> fetchForeCasts(homeViewIntent)
                }
            }
            .launchIn(viewModelScope)
    }

    suspend fun processIntent(intent: HomeViewIntent) = _intentChannel.send(intent)

    private suspend fun fetchForeCasts(forecastRepo: HomeViewIntent.FetchForecasts) {
        val forecastDomainData =
            fetchForecastUseCase(FetchForecastUseCase.Params("Thanh pho Ho Chi Minh,vn"))
        if (forecastDomainData is Success<ForecastDomainModel>) {
            _uiEvents.value = HomeUIEvent.Forecasts(forecastDomainData.get())
        }
    }

}