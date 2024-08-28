package com.plcoding.weatherapp.di

import com.plcoding.weatherapp.data.Location.DefaultLocationTracker
import com.plcoding.weatherapp.domain.Location.LocationTracker
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class LocationModule {

    @Binds
    @Singleton
   abstract fun provideLocationTracker(defaultLocationTracker: DefaultLocationTracker) : LocationTracker

}