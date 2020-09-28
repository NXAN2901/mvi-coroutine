package com.example.mvi.ui.home

import com.example.mvi.weather.remoterepo.weather.model.forecast.ForecastDomainModel

sealed class HomeUIEvent {
  data class Forecasts(val data: ForecastDomainModel): HomeUIEvent()
}