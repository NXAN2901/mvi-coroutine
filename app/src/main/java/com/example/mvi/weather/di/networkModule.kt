package com.example.mvi.weather.di

import com.example.mvi.weather.BuildConfig
import com.example.mvi.weather.remoterepo.weather.WeatherAPIService
import com.example.mvi.weather.remoterepo.weather.mappers.CurrentWeatherResponseToDomainMapper
import com.example.mvi.weather.remoterepo.weather.mappers.ForecastResponseToDomainMapper
import com.example.mvi.weather.remoterepo.weather.repos.current.CurrentWeatherRepo
import com.example.mvi.weather.remoterepo.weather.repos.current.CurrentWeatherRepoImpl
import com.example.mvi.weather.remoterepo.weather.repos.threehour.FiveDaysThreeHourWeatherRepo
import com.example.mvi.weather.remoterepo.weather.repos.threehour.FiveDaysThreeHourWeatherRepoImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@ExperimentalCoroutinesApi
@FlowPreview
val networkModule = module {

    single(named("appId")) { BuildConfig.APP_ID }

    single {
        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).build()
    }

    single {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .baseUrl(BuildConfig.WEATHER_BASE_URL)
            .build()
    }

    single<WeatherAPIService> { get<Retrofit>().create(WeatherAPIService::class.java) }

    single<FiveDaysThreeHourWeatherRepo> {
        FiveDaysThreeHourWeatherRepoImpl(
            get(),
            get(),
            get<ForecastResponseToDomainMapper>()
        )
    }

    single<CurrentWeatherRepo> {
        CurrentWeatherRepoImpl(
            get(),
            get(),
            get<CurrentWeatherResponseToDomainMapper>()
        )
    }

}