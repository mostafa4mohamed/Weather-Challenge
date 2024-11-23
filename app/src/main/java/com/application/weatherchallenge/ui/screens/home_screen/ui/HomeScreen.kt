package com.application.weatherchallenge.ui.screens.home_screen.ui

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.application.weatherchallenge.state.NetworkState
import com.application.weatherchallenge.ui.screens.home_screen.HomeViewModel


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {

    val onButtonClick: () -> Unit = {
        if (viewModel.inputText.value.isNotBlank())
            viewModel.cityInput.value=viewModel.inputText.value
            getDailyForecast(viewModel)
    }

    when (val state = viewModel.getDailyForecastStateFlow.collectAsState().value) {
        is NetworkState.Error -> ErrorContent(
            message = state.msg,
            inputText = viewModel.inputText,
            onRetryClick = onButtonClick
        )

        NetworkState.Idle -> InitContent(viewModel.inputText, onButtonClick)
        NetworkState.Loading -> LoadingContent(viewModel.inputText, onButtonClick)
        is NetworkState.Result -> HomeContent(viewModel, onButtonClick)
    }

}

private fun getDailyForecast(viewModel: HomeViewModel) {

    viewModel.getDailyForecastByCity()

}