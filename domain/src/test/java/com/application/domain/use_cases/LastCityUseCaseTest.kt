package com.application.domain.use_cases

import com.application.domain.repo.LastCityRepo
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class LastCityUseCaseTest {


    @Test
    fun `getLastCity return data`() = runBlocking {

        val city="test"

        //arrange
        val repo = object : LastCityRepo {
            override suspend fun getLastCity(): String{
                return "test"
            }

            override suspend fun saveLastCity(cityName: String) {
                TODO("Not yet implemented")
            }


        }
        val useCase = LastCityUseCase(repo)

        //act
        val expected=useCase.getLastCity()

        //assert
        assert(expected==city)

    }

    @Test
    fun `getLastCity return null`() = runBlocking {


        //arrange
        val repo = object : LastCityRepo {
            override suspend fun getLastCity(): String? {
                return null
            }

            override suspend fun saveLastCity(cityName: String) {
                TODO("Not yet implemented")
            }


        }
        val useCase = LastCityUseCase(repo)

        //act
        val expected=useCase.getLastCity()

        //assert
        Assert.assertNull(expected)

    }

    @Test
    fun `saveLastCity return success`()  = runBlocking {

        var action =true
        //arrange
        val repo = object : LastCityRepo {
            override suspend fun getLastCity(): String{
                TODO("Not yet implemented")
            }

            override suspend fun saveLastCity(cityName: String) {
                action =true
            }


        }
        val useCase = LastCityUseCase(repo)

        //act
        useCase.saveLastCity("")

        //assert
        assert(action)
    }
    @Test
    fun `saveLastCity return false`()  = runBlocking {

        var action =false
        //arrange
        val repo = object : LastCityRepo {
            override suspend fun getLastCity(): String{
                TODO("Not yet implemented")
            }

            override suspend fun saveLastCity(cityName: String) {
                action =false
            }


        }
        val useCase = LastCityUseCase(repo)

        //act
        useCase.saveLastCity("")

        //assert
        assert(!action)
    }

}