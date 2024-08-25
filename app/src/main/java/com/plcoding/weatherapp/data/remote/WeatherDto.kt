package com.plcoding.weatherapp.data.remote

import com.plcoding.weatherapp.WeatherDataDto
import com.squareup.moshi.Json

data class WeatherDto(
    @field:Json(name = "hourly")
    val weatherData : WeatherDataDto
)