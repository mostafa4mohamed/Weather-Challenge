package com.application.weatherutils

import com.application.weatherutils.WeatherFormatter.convertFromKelvinToCelsius
import com.application.weatherutils.WeatherFormatter.format2Digits
import com.application.weatherutils.WeatherFormatter.formatTemperatureToCelsius
import com.application.weatherutils.WeatherFormatter.getFillImageUrl
import org.junit.Test

class WeatherFormatterTest {

    @Test
    fun formatTemperatureToCelsius() {

        val result=300.6543.formatTemperatureToCelsius()

        val expected="27.50 ℃"

        assert(result == expected)
    }

    @Test
    fun convertFromKelvinToCelsius() {

        val result = 280.15.convertFromKelvinToCelsius()

        val expected = 7.0

        assert(result == expected)

    }

    @Test
    fun getFillImageUrl() {

        val icon="icon"

        val result = icon.getFillImageUrl()

        val expected = "https://openweathermap.org/img/wn/icon@2x.png"

        assert(result == expected)

    }

    @Test
    fun `format2Digits return data`() {


        val result = 33.12345.format2Digits()

        val expected = 33.12.toString()

        assert(result == expected)

    }

    @Test
    fun `format2Digits with null data`() {

        val input: Double? = null
        val result = input.format2Digits()

        assert(result.isEmpty())

    }
}