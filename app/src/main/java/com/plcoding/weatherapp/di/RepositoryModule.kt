package com.plcoding.weatherapp.di

import com.plcoding.weatherapp.data.repository.WeatherRepositoryImp
import com.plcoding.weatherapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.koin.dsl.module
import javax.inject.Singleton


val repositoryModule = module {
    single<WeatherRepository> {
        WeatherRepositoryImp(get())
    }
}