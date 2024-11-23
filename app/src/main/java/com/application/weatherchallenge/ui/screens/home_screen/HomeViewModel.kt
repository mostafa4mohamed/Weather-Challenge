package com.application.weatherchallenge.ui.screens.home_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.application.domain.entities.DailyForecastData
import com.application.domain.entities.DailyForecastResponse
import com.application.domain.use_cases.GetDailyForecastByCityUseCase
import com.application.domain.use_cases.InsertDailyForecastByCityInRoomUseCase
import com.application.domain.use_cases.LastCityUseCase
import com.application.weatherchallenge.base.BaseViewModel
import com.application.weatherchallenge.state.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getDailyForecastByCityUseCase: GetDailyForecastByCityUseCase,
    private val insertDailyForecastByCityInRoomUseCase: InsertDailyForecastByCityInRoomUseCase,
    private val lastCityUseCase: LastCityUseCase,
) :
    BaseViewModel() {

    private val _getDailyForecastStateFlow =
        MutableStateFlow<NetworkState<DailyForecastResponse?>>(NetworkState.Idle)
    val getDailyForecastStateFlow get() = _getDailyForecastStateFlow

    var inputText = mutableStateOf("")
        private set
    var cityInput = mutableStateOf("")
        private set

    init {
        viewModelScope.launch {
            val lastCity = lastCityUseCase.getLastCity() ?: ""
            inputText.value = lastCity
            cityInput.value = lastCity
            loadInitialData()
        }
    }

    private fun loadInitialData() {

        val cityName = inputText.value.lowercase().trim()
        if (cityName.isEmpty()) return

        _getDailyForecastStateFlow.value = NetworkState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val data = invokeFromRoom(cityName)
                if (!data?.list.isNullOrEmpty())
                    _getDailyForecastStateFlow.value = NetworkState.Result(data, false)
                else
                    _getDailyForecastStateFlow.value = NetworkState.Idle

            } catch (_: Exception) {
            }
        }

    }

    fun getDailyForecastByCity() {

        val cityName = cityInput.value.lowercase().trim()
        viewModelScope.launch {
            saveLastCity(cityName)
        }

        _getDailyForecastStateFlow.value = NetworkState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                getDailyForecastByCityUseCase.invokeFromRemote(
                    cityName
                )
            }.onFailure { th ->
                try {
                    val data = invokeFromRoom(cityName)
                    if (data?.list.isNullOrEmpty())
                        _getDailyForecastStateFlow.value = NetworkState.Error(msg = th.message)
                    else
                        _getDailyForecastStateFlow.value = NetworkState.Result(data, false)

                } catch (_: Exception) {
                    _getDailyForecastStateFlow.value = NetworkState.Error(msg = th.message)
                }
            }.onSuccess {

                val isOnline: Boolean
                val data: DailyForecastResponse?

                if (it != null) {
                    isOnline = true
                    saveAtRoom(cityName, it.list)
                    data = it
                } else {

                    try {
                        isOnline = false
                        data = invokeFromRoom(cityName)

                    } catch (e: Exception) {
                        _getDailyForecastStateFlow.value = NetworkState.Error(msg = e.message)
                        return@onSuccess
                    }

                }

                _getDailyForecastStateFlow.value = NetworkState.Result(data, isOnline)

            }
        }
    }


    private suspend fun saveLastCity(cityName: String) {
        lastCityUseCase.saveLastCity(cityName)
    }

    private suspend fun saveAtRoom(cityName: String, list: List<DailyForecastData>?) {

        if (list.isNullOrEmpty()) return

        val data: List<DailyForecastData> = list.map {
            it.city_name = cityName
            it
        }

        insertDailyForecastByCityInRoomUseCase.insertData(data)
    }

    private suspend fun invokeFromRoom(cityName: String) =
        getDailyForecastByCityUseCase.invokeFromLocalData(cityName)

}