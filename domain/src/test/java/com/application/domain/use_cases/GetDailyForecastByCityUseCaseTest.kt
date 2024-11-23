package com.application.domain.use_cases

import com.application.domain.entities.DailyForecastData
import com.application.domain.entities.DailyForecastResponse
import com.application.domain.repo.DailyForecastRepo
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.assertNull
import org.junit.Test

class GetDailyForecastByCityUseCaseTest {

    @Test
    fun `invokeFromRemote return data`() = runBlocking {

        val list = DailyForecastResponse()

        //arrange
        val repo = object : DailyForecastRepo {
            override suspend fun getDailyForecastByCityFromRemote(
                cityName: String
            ): DailyForecastResponse = list

            override suspend fun getDailyForecastByCityFromLocalDataBase(cityName: String): DailyForecastResponse {
                TODO("Not yet implemented")
            }

            override suspend fun insertDailyForecastByCityToLocalDataBase(data: List<DailyForecastData>) {
                TODO("Not yet implemented")
            }

        }
        val useCase = GetDailyForecastByCityUseCase(repo)

        //act
        val result = useCase.invokeFromRemote("")

        //assert
        val expected = list
        Assert.assertEquals(expected, result)

    }

    @Test
    fun `invokeFromRemote return null`() = runBlocking {

        //arrange
        val repo = object : DailyForecastRepo {
            override suspend fun getDailyForecastByCityFromRemote(
                cityName: String
            ): DailyForecastResponse? = null

            override suspend fun getDailyForecastByCityFromLocalDataBase(cityName: String): DailyForecastResponse {
                TODO("Not yet implemented")
            }

            override suspend fun insertDailyForecastByCityToLocalDataBase(data: List<DailyForecastData>) {
                TODO("Not yet implemented")
            }

        }
        val useCase = GetDailyForecastByCityUseCase(repo)

        //act
        val result = useCase.invokeFromRemote("")

        //assert
        assertNull(result)

    }

    @Test(expected = UnsupportedOperationException::class)
    fun `invokeFromRemote return Exception`() = runBlocking {

        val list = DailyForecastResponse()

        //arrange
        val repo = object : DailyForecastRepo {
            override suspend fun getDailyForecastByCityFromRemote(
                cityName: String
            ): DailyForecastResponse {
                throw UnsupportedOperationException()
            }

            override suspend fun getDailyForecastByCityFromLocalDataBase(cityName: String): DailyForecastResponse {
                TODO("Not yet implemented")
            }

            override suspend fun insertDailyForecastByCityToLocalDataBase(data: List<DailyForecastData>) {
                TODO("Not yet implemented")
            }

        }
        val useCase = GetDailyForecastByCityUseCase(repo)

        //act
        val result = useCase.invokeFromRemote("")

        //assert
        val expected = list
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `invokeFromLocalData return data`() = runBlocking {

        val list = DailyForecastResponse()

        //arrange
        val repo = object : DailyForecastRepo {
            override suspend fun getDailyForecastByCityFromRemote(
                cityName: String
            ): DailyForecastResponse {
                TODO("Not yet implemented")
            }

            override suspend fun getDailyForecastByCityFromLocalDataBase(cityName: String): DailyForecastResponse =
                list

            override suspend fun insertDailyForecastByCityToLocalDataBase(data: List<DailyForecastData>) {
                TODO("Not yet implemented")
            }

        }
        val useCase = GetDailyForecastByCityUseCase(repo)

        //act
        val result = useCase.invokeFromLocalData("")

        //assert
        val expected = list
        Assert.assertEquals(expected, result)

    }

    @Test
    fun `invokeFromLocalData return null`() = runBlocking {

        //arrange
        val repo = object : DailyForecastRepo {
            override suspend fun getDailyForecastByCityFromRemote(
                cityName: String
            ): DailyForecastResponse {
                TODO("Not yet implemented")
            }

            override suspend fun getDailyForecastByCityFromLocalDataBase(cityName: String): DailyForecastResponse? =
                null

            override suspend fun insertDailyForecastByCityToLocalDataBase(data: List<DailyForecastData>) {
                TODO("Not yet implemented")
            }

        }
        val useCase = GetDailyForecastByCityUseCase(repo)

        //act
        val result = useCase.invokeFromLocalData("")

        //assert
        assertNull(result)

    }

    @Test(expected = UnsupportedOperationException::class)
    fun `invokeFromLocalData return Exception`() = runBlocking {

        val list = DailyForecastResponse()

        //arrange
        val repo = object : DailyForecastRepo {
            override suspend fun getDailyForecastByCityFromRemote(
                cityName: String
            ): DailyForecastResponse {
                TODO("Not yet implemented")
            }

            override suspend fun getDailyForecastByCityFromLocalDataBase(cityName: String): DailyForecastResponse {
                throw UnsupportedOperationException()
            }

            override suspend fun insertDailyForecastByCityToLocalDataBase(data: List<DailyForecastData>) {
                TODO("Not yet implemented")
            }

        }
        val useCase = GetDailyForecastByCityUseCase(repo)

        //act
        val result = useCase.invokeFromLocalData("")

        //assert
        val expected = list
        Assert.assertEquals(expected, result)
    }

}