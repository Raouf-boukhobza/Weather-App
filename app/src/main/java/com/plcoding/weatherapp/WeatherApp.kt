package com.plcoding.weatherapp

import android.app.Application
import com.plcoding.weatherapp.di.appModule
import com.plcoding.weatherapp.di.locationModule
import com.plcoding.weatherapp.di.repositoryModule
import com.plcoding.weatherapp.di.viewModelModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class WeatherApp : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WeatherApp)
            modules(appModule, repositoryModule, locationModule, viewModelModule)
        }
    }
}