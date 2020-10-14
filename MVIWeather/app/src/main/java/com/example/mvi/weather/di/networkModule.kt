package com.example.mvi.weather.di

import com.example.mvi.weather.remoterepo.FiveDayWeatherRepoImpl
import com.example.mvi.weather.remoterepo.weather.WeatherAPIService
import com.example.mvi.weather.remoterepo.weather.FiveDayWeatherRepo
import com.example.mvi.weather.remoterepo.weather.mappers.ForecastResponseToDomainMapper
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

@ExperimentalCoroutinesApi
@FlowPreview
val networkModule = module {
    single {
        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).build()
    }

    single { Moshi.Builder().add(Date::class.java, Rfc3339DateJsonAdapter()).build() }

    single {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .baseUrl("http://api.openweathermap.org/")
            .build()
    }

    single<FiveDayWeatherRepo> {
        FiveDayWeatherRepoImpl(
            get<Retrofit>().create(WeatherAPIService::class.java),
            get(),
            get<ForecastResponseToDomainMapper>()
        )
    }

}