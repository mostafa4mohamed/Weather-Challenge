package com.application.weatherchallenge.ui.screens.home_screen.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.application.weatherchallenge.R

@Composable
fun InitContent(
    inputText: MutableState<String>,
    onButtonClick:()->Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        SearchBar(inputText, onButtonClick)

        Text(
            text = stringResource(R.string.enter_your_city_name_to_start),
            color = MaterialTheme.colorScheme.primary,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.Center),
            style = MaterialTheme.typography.bodyLarge
        )

    }
}