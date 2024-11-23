package com.application.weatherchallenge.di

import com.application.data.impl.DailyForecastRepoImpl
import com.application.data.impl.LastCityRepoImpl
import com.application.data.local.DailyForecastDao
import com.application.data.preferences.UserPreferences
import com.application.data.remote.DailyForecastServices
import com.application.domain.repo.DailyForecastRepo
import com.application.domain.repo.LastCityRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideGetDailyForecastRepo(apiServices: DailyForecastServices,dao: DailyForecastDao): DailyForecastRepo =
        DailyForecastRepoImpl(apiServices,dao)

@Provides
    fun provideLastCityRepo(userPreferences: UserPreferences): LastCityRepo =
        LastCityRepoImpl(userPreferences)


}