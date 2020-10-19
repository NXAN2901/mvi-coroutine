package com.example.mvi.weather.remoterepo.weather.mappers

import com.example.mvi.core.domain.Mapper
import com.example.mvi.core.domain.entity.common.Main
import com.example.mvi.weather.remoterepo.weather.model.common.MainResponse

class MainResponseToMainDomainMapper : Mapper<MainResponse, Main> {
    override fun invoke(response: MainResponse): Main {
        return Main(
            temp = response.temp,
            tempMax = response.tempMax,
            tempMin = response.tempMin
        )
    }

}