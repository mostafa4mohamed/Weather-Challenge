package com.application.weatherchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.application.weatherchallenge.ui.screens.home_screen.ui.HomeScreen
import com.application.weatherchallenge.ui.theme.WeatherChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HomeScreen()
            //test.
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherChallengeTheme {
        HomeScreen()
    }
}