package com.plcoding.weatherapp.domain.Location

import android.location.Location

interface LocationTracker  {
    suspend fun getLocation() : Location?
}