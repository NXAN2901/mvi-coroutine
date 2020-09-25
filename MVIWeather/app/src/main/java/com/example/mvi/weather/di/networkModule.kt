package com.example.mvi.weather.di

import com.example.mvi.weather.remoterepo.WeatherRemoteRepoImpl
import com.example.mvi.weather.remoterepo.weather.WeatherAPIService
import com.example.mvi.weather.remoterepo.weather.WeatherRemoteRepo
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*

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

    single<WeatherRemoteRepo> {
        WeatherRemoteRepoImpl(get<Retrofit>().create(WeatherAPIService::class.java))
    }

}