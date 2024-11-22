package com.application.weatherchallenge.di

import com.application.domain.repo.DailyForecastRepo
import com.application.domain.use_cases.GetDailyForecastByCityUseCase
import com.application.domain.use_cases.InsertDailyForecastByCityInRoomUseCase
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
}