package com.application.weatherchallenge.ui.screens.home_screen.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.application.weatherchallenge.R
import com.application.weatherchallenge.utils.Utils.fillImageUrl
import com.intuit.sdp.R.dimen

@Composable
fun WeatherInfoCard(
    date: String,
    temp: String,
    humidity: String,
    description: String,
    windSpeed: String,
    icon: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimensionResource(id = dimen._14sdp),
                vertical = dimensionResource(id = dimen._8sdp)
            ),
        shape = RoundedCornerShape(dimensionResource(id = dimen._7sdp)),
    ) {

        Row {
            MyImage(icon)
            MyBody(date, temp, humidity, description, windSpeed)
        }

    }
}

@Composable
fun RowScope.MyImage(icon: String) {
    Image(
        painter = rememberImagePainter(data = icon.fillImageUrl()),
        contentDescription = stringResource(id = R.string.weather_icon),
        modifier = Modifier
            .size(dimensionResource(id = dimen._48sdp))
            .align(Alignment.CenterVertically)
            .padding(bottom = dimensionResource(id = dimen._8sdp)),
        contentScale = ContentScale.Fit
    )
}

@Composable
fun RowScope.MyBody(
    date: String,
    temp: String,
    humidity: String,
    description: String,
    windSpeed: String
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .padding(dimensionResource(id = dimen._4sdp))
    ) {
        InfoRow(
            key = stringResource(id = R.string.date),
            value = date,
            keyColor = colorResource(id = R.color.teal_200)
        )
        InfoRow(
            key = stringResource(id = R.string.temp),
            value = temp,
            keyColor = colorResource(id = R.color.teal_200)
        )
        InfoRow(
            key = stringResource(id = R.string.humidity),
            value = humidity,
            keyColor = colorResource(id = R.color.teal_200)
        )
        InfoRow(
            key = stringResource(id = R.string.description),
            value = description,
            keyColor = colorResource(id = R.color.teal_200)
        )
        InfoRow(
            key = stringResource(id = R.string.wind_speed),
            value = windSpeed,
            keyColor = colorResource(id = R.color.teal_200)
        )
    }
}

@Composable
fun InfoRow(
    key: String,
    value: String,
    keyColor: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = dimensionResource(id = dimen._2sdp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = key,
            color = keyColor,
            fontSize = dimensionResource(id = com.intuit.ssp.R.dimen._12ssp).value.sp,
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = dimen._4sdp))
        )
        Text(
            text = value,
            fontSize = dimensionResource(id = com.intuit.ssp.R.dimen._12ssp).value.sp,
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = dimen._4sdp))
                .weight(1f)
        )
    }
}