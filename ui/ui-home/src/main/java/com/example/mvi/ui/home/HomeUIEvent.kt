package com.example.mvi.ui.home

import com.example.mvi.weather.remoterepo.weather.model.forecast.FiveDayForecastResponse

sealed class HomeUIEvent {
  data class Forecasts(val data: FiveDayForecastResponse): HomeUIEvent()
  object LoadForeCasts: HomeUIEvent()
}