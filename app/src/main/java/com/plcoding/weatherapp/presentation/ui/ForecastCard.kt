package com.plcoding.weatherapp.presentation.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ForecastCard(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    hour:LocalDateTime,
    temperature: String,
    backgroundColor: Color
) {

    Card(
        shape = RoundedCornerShape(16.dp),
        backgroundColor = backgroundColor
    ) {
        Row {
            Icon(
                imageVector = icon, contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Column {
                Text(
                    text = hour.format(
                        DateTimeFormatter.ofPattern("HH:mm")
                    ),
                    fontSize = 16.sp,
                    color = Color.White
                )
                Text(
                    text = "$temperature°C",
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }
    }

}