package com.plcoding.weatherapp.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


@Composable
fun WeatherDataDisplay(
    value :String,
    unit : String,
    icon: ImageVector,
    iconTint : Color = Color.White
) {
    Row(verticalAlignment = Alignment.CenterVertically){
        Icon(imageVector =icon , contentDescription = null,
            tint = iconTint,
            modifier = Modifier.size(25.dp)
        )
        Text(
                text = value + unit,
        color = Color.White,
        )
    }

}