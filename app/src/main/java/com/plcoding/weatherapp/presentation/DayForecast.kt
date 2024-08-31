package com.plcoding.weatherapp.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.weatherapp.presentation.ui.ForecastCard
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DayForecast(
    state: WeatherState,
    backgroundcolor : Color
    ) {
    state.weatherInfo?.weatherDataPerDay?.get(0)?.let { data ->

        Text(
            text = "Today",
            fontSize = 28.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            modifier = Modifier.padding(start = 16.dp)
        )

        LazyRow (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            item {
                Spacer(modifier = Modifier.size(height = 125.dp , width = 0.dp))
            }
            items(data){ dataOnHour ->
                ForecastCard(
                    icon = dataOnHour.weatherType.iconRes,
                    backgroundColor = backgroundcolor,
                    hour = dataOnHour.time,
                    temperature = dataOnHour.temperatureCelsius.toString()
                )
            }
        }

    }

}
