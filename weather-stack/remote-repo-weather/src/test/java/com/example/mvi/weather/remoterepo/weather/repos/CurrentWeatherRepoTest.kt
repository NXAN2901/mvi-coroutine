package com.example.mvi.weather.remoterepo.weather.repos

import com.example.mvi.core.domain.entity.common.MainDomain
import com.example.mvi.core.domain.entity.current.CurrentWeatherDomain
import com.example.mvi.coredispatchers.CoroutineDispatchers
import com.example.mvi.coredispatchers.CoroutineDispatchersImpl
import com.example.mvi.weather.remoterepo.weather.CoroutineTestRule
import com.example.mvi.weather.remoterepo.weather.WeatherAPIService
import com.example.mvi.weather.remoterepo.weather.mappers.CurrentWeatherResponseToDomainMapper
import com.example.mvi.weather.remoterepo.weather.model.common.CoordinationResponse
import com.example.mvi.weather.remoterepo.weather.model.common.MainResponse
import com.example.mvi.weather.remoterepo.weather.model.common.RainResponse
import com.example.mvi.weather.remoterepo.weather.model.common.WindResponse
import com.example.mvi.weather.remoterepo.weather.model.current.CurrentWeatherResponse
import com.example.mvi.weather.remoterepo.weather.model.forecast.CloudsResponse
import com.example.mvi.weather.remoterepo.weather.model.forecast.SysResponse
import com.example.mvi.weather.remoterepo.weather.repos.current.CurrentWeatherRepoImpl
import io.mockk.*
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.withContext
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@FlowPreview
@ExperimentalCoroutinesApi
class CurrentWeatherRepoTest {


    @get:Rule
    val coroutinesTestRule = CoroutineTestRule()

    private val apiService = mockk<WeatherAPIService>()
    private val mapper = mockk<CurrentWeatherResponseToDomainMapper>()
    private val repository = CurrentWeatherRepoImpl(
        apiService,
        coroutinesTestRule.testDispatcherProvider,
        mapper
    )

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `fetch Weather Successfully`() = coroutinesTestRule.testDispatcher.runBlockingTest {
        val expectedDomainModel = CurrentWeatherDomain(
            id = 2901,
            timezone = 2901,
            name = "ANNX",
            dt = 2901,
            main = MainDomain(temp = 29f, tempMax = 29f, tempMin = 29f),
            weathersInfo = emptyList()
        )
        every { mapper.invoke(any()) }.returns(
            expectedDomainModel
        )
        val mainResponse = mockk<MainResponse>()
        val windResponse = mockk<WindResponse>()
        val rainResponse = mockk<RainResponse>()
        val cloudResponse = mockk<CloudsResponse>()
        val sysResponse = mockk<SysResponse>()
        val coordResponse = mockk<CoordinationResponse>()
        coEvery { apiService.fetchCurrentWeatherByCity(any(), any(), any()) } coAnswers {
            CurrentWeatherResponse(
                id = 2901,
                timezone = 2901,
                name = "ANNX",
                base = "base",
                main = mainResponse,
                visibility = 2901,
                wind = windResponse,
                rain = rainResponse,
                clouds = cloudResponse,
                dt = 2901,
                sys = sysResponse,
                cod = 200,
                coordination = coordResponse,
                weathersInfo = emptyList()
            )
        }

        repository.getCurrentWeather("", "", "").onEach {actual ->
            assertEquals(2901, actual.id)
            assertEquals(expectedDomainModel, actual)
        }
//        coVerify (exactly = 1) { apiService.fetchCurrentWeatherByCity(any(), any(), any()) }
    }

}