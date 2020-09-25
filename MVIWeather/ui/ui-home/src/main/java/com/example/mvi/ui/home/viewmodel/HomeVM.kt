package com.example.mvi.ui.home.viewmodel

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.example.mvi.ui.base.BaseViewModel
import com.example.mvi.usecase.weather.FetchForecastUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeVM(application: Application, private val fetchForecastUseCase: FetchForecastUseCase) : BaseViewModel(application) {

    init {

        GlobalScope.launch {
            fetchForeCasts()
        }
    }

    suspend fun fetchForeCasts() {
        viewModelScope.launch {
            fetchForecastUseCase(FetchForecastUseCase.Params("Thanh pho Ho Chi Minh,vn"))
        }

    }

}