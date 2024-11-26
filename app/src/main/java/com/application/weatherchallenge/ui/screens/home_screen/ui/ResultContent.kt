package com.application.weatherchallenge.ui.screens.home_screen.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.application.weatherchallenge.R
import com.application.weatherchallenge.state.NetworkState
import com.application.weatherchallenge.ui.screens.home_screen.HomeViewModel
import com.application.weatherchallenge.utils.DateUtils.dateFormat
import com.application.weatherutils.WeatherFormatter.formatTemperatureToCelsius


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun HomeContent(
    viewModel: HomeViewModel,
    onButtonClick: () -> Unit
) {

    val inputText = viewModel.inputText
    val resultState =
        viewModel.getDailyForecastStateFlow.collectAsState().value as NetworkState.Result

    val backgroundColor = MaterialTheme.colorScheme.background

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {

        SearchBar(inputText, onButtonClick)

        if (resultState.onlineState == false) {

            val cityName = viewModel.cityInput.value

            val hint = if (cityName.isEmpty())
                stringResource(id = R.string.it_is_not_accurate_data)
            else
                stringResource(id = R.string.it_is_not_accurate_data) +
                        " ${stringResource(id = R.string._for)} " +
                        cityName

            Text(
                text = hint,
                color = Color.Red,
                fontSize = dimensionResource(id = com.intuit.ssp.R.dimen._12ssp).value.sp,
                modifier = Modifier
                    .padding(horizontal = dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))
                    .padding(top = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp))
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(id = com.intuit.sdp.R.dimen._6sdp))
        ) {

            if (resultState.response?.list.isNullOrEmpty()) return@LazyColumn

            items(resultState.response!!.list!!) { data ->

                val date = "${data.dt_txt.dateFormat()}"
                val temp = data.main?.temp?.formatTemperatureToCelsius() ?: ""
                val humidity = "${data.main?.humidity} %"
                val description = if (!data.weather.isNullOrEmpty())
                    data.weather?.first()?.description ?: ""
                else ""
                val windSpeed = "${data.wind?.speed} k/hr"
                val icon=data.weather?.firstOrNull()?.icon ?: ""

                WeatherInfoCard(
                    date = date,
                    temp = temp,
                    humidity = humidity,
                    description = description,
                    windSpeed = windSpeed,
                    icon= icon
                )

            }
        }
        HorizontalDivider(modifier = Modifier.padding(horizontal = dimensionResource(id = com.intuit.sdp.R.dimen._14sdp)))
    }
}


@Composable
fun SearchBar(inputText: MutableState<String>, onButtonClick: () -> Unit) {


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))
            .padding(top = dimensionResource(id = com.intuit.sdp.R.dimen._32sdp))

    ) {
        OutlinedTextField(
            value = inputText.value,
            onValueChange = { inputText.value = it },
            label = { Text(stringResource(com.application.weatherchallenge.R.string.enter_city_name)) },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shape = RoundedCornerShape(dimensionResource(id = com.intuit.sdp.R.dimen._6sdp))
        )

        Button(
            onClick = { onButtonClick() },
            modifier = Modifier
                .padding(start = dimensionResource(id = com.intuit.sdp.R.dimen._6sdp))
                .align(Alignment.CenterVertically)
        ) {
            Text(stringResource(id = com.application.weatherchallenge.R.string.search))
        }
    }

}
