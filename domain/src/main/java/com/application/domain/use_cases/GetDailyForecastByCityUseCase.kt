package com.application.domain.use_cases

import com.application.domain.repo.DailyForecastRepo

class GetDailyForecastByCityUseCase (private val repo: DailyForecastRepo) {

    suspend fun invokeFromRemote(
        cityName:String
    ) = repo.getDailyForecastByCityFromRemote(cityName)

    suspend fun invokeFromLocalData(
        cityName:String
    ) = repo.getDailyForecastByCityFromLocalDataBase(cityName)

}