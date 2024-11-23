package com.application.weatherchallenge.di

import com.application.domain.repo.DailyForecastRepo
import com.application.domain.repo.LastCityRepo
import com.application.domain.use_cases.GetDailyForecastByCityUseCase
import com.application.domain.use_cases.InsertDailyForecastByCityInRoomUseCase
import com.application.domain.use_cases.LastCityUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetDailyForecastUseCase(repo: DailyForecastRepo) =
        GetDailyForecastByCityUseCase(repo)


    @Provides
    fun provideInsertDailyForecastByCityInRoomUseCase(repo: DailyForecastRepo) =
        InsertDailyForecastByCityInRoomUseCase(repo)

    @Provides
    fun provideLastCityUseCase(repo: LastCityRepo) =
        LastCityUseCase(repo)
}