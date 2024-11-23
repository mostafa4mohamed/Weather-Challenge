package com.application.data.impl

import com.application.data.local.DailyForecastDao
import com.application.data.mapper.DailyForecastMapper.toDomainEntity
import com.application.data.mapper.DailyForecastMapper.toRoomEntity
import com.application.data.remote.DailyForecastServices
import com.application.domain.entities.DailyForecastData
import com.application.domain.entities.DailyForecastResponse
import com.application.domain.repo.DailyForecastRepo

class DailyForecastRepoImpl(
    private val apis: DailyForecastServices,
    private val dao: DailyForecastDao
) : DailyForecastRepo {

    override suspend fun getDailyForecastByCityFromRemote(
        cityName:String
    ): DailyForecastResponse =
        apis.getDailyForecastByCityFromRemote(cityName)

    override suspend fun getDailyForecastByCityFromLocalDataBase(
        cityName:String
    ): DailyForecastResponse =
        DailyForecastResponse(list = dao.getDailyForecastByCity(cityName).map { it.toDomainEntity() })

    override suspend fun insertDailyForecastByCityToLocalDataBase(data: List<DailyForecastData>) {
        dao.insert(data.map { it.toRoomEntity() })
    }


}