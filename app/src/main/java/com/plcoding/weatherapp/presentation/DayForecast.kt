package com.plcoding.weatherapp.presentation

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DayForecast(
    state: WeatherState,

) {

    state.weatherInfo?.weatherDataPerDay?.get(0)?.let { data ->


    }

}
