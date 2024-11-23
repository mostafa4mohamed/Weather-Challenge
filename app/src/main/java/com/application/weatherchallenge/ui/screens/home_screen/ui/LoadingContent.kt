package com.application.weatherchallenge.ui.screens.home_screen.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LoadingContent(
    inputText: MutableState<String>,
    onButtonClick:()->Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {

        SearchBar(inputText, onButtonClick)

        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}