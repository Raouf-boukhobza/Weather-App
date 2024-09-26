package com.plcoding.weatherapp.di

import com.plcoding.weatherapp.data.repository.WeatherRepositoryImp
import com.plcoding.weatherapp.domain.repository.WeatherRepository
import org.koin.dsl.module


val repositoryModule = module {
    single<WeatherRepository> {
        WeatherRepositoryImp(get())
    }
}