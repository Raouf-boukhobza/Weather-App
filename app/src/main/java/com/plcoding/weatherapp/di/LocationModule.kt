package com.plcoding.weatherapp.di

import com.plcoding.weatherapp.data.Location.DefaultLocationTracker
import com.plcoding.weatherapp.domain.Location.LocationTracker
import org.koin.dsl.module


val locationModule = module {
    single<LocationTracker> {
        DefaultLocationTracker(get(),get())
    }
}