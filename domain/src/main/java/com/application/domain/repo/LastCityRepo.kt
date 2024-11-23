package com.application.domain.repo

interface LastCityRepo {

  suspend  fun getLastCity(): String?

    suspend fun saveLastCity(cityName: String)

}