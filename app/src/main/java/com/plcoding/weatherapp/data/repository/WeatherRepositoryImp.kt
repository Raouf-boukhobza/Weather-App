package com.plcoding.weatherapp.data.repository

import com.plcoding.weatherapp.data.mappers.toweatherinfo
import com.plcoding.weatherapp.data.remote.WeatherApi
import com.plcoding.weatherapp.domain.repository.WeatherRepository
import com.plcoding.weatherapp.domain.util.Resource
import com.plcoding.weatherapp.domain.weather.WeatherInfo

class WeatherRepositoryImp (
    private val weatherApi: WeatherApi
) : WeatherRepository {

    override suspend fun getWeatherInfo(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                weatherApi.getWeatherData(
                    lat = lat,
                    long = long
                ).toweatherinfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(message = e.message ?: "Unknown error type")
        }
    }
}