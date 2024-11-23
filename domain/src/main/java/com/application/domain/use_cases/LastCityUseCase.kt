package com.application.domain.use_cases

import com.application.domain.repo.LastCityRepo

class LastCityUseCase(private val repo: LastCityRepo) {


    suspend fun getLastCity(): String? = repo.getLastCity()


    suspend fun saveLastCity(cityName: String) = repo.saveLastCity(cityName)


}