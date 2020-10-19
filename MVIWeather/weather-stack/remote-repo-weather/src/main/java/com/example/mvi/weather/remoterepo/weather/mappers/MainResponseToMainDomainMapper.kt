package com.example.mvi.weather.remoterepo.weather.mappers

import com.example.mvi.core.domain.Mapper
import com.example.mvi.core.domain.entity.common.MainDomain
import com.example.mvi.weather.remoterepo.weather.model.common.MainResponse

class MainResponseToMainDomainMapper : Mapper<MainResponse, MainDomain> {
    override fun invoke(response: MainResponse): MainDomain {
        return MainDomain(
            temp = response.temp,
            tempMax = response.tempMax,
            tempMin = response.tempMin
        )
    }

}