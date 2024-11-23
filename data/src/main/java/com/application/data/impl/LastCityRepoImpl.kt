package com.application.data.impl

import com.application.data.preferences.UserPreferences
import com.application.domain.repo.LastCityRepo
import kotlinx.coroutines.flow.first

class LastCityRepoImpl(private val userPreferences: UserPreferences) : LastCityRepo {
    override suspend fun getLastCity(): String? = userPreferences.lastCityName.first()

    override suspend fun saveLastCity(cityName: String) = userPreferences.saveLastCityName(cityName)
}