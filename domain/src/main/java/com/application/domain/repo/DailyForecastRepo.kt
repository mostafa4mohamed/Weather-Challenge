package com.application.domain.repo

import com.application.domain.entities.DailyForecastData
import com.application.domain.entities.DailyForecastResponse

interface DailyForecastRepo {

    suspend fun getDailyForecastByCityFromRemote(
        cityName:String,
    ): DailyForecastResponse?

    suspend fun getDailyForecastByCityFromLocalDataBase(
        cityName:String,
    ): DailyForecastResponse?

    suspend fun insertDailyForecastByCityToLocalDataBase(
        data: List<DailyForecastData>
    )

}