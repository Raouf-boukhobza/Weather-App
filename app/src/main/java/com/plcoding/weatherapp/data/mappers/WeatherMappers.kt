package com.plcoding.weatherapp.data.mappers

import com.plcoding.weatherapp.data.remote.WeatherDataDto
import com.plcoding.weatherapp.data.remote.WeatherDto
import com.plcoding.weatherapp.domain.weather.WeatherData
import com.plcoding.weatherapp.domain.weather.WeatherInfo
import com.plcoding.weatherapp.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


private data class indexWeatherData(
    val index : Int,
    val weatherData: WeatherData
)

fun WeatherDataDto.toweatehrDataMap() : Map<Int , List<WeatherData>>{
    return time.mapIndexed{ index, time ->
        val temperature = temperatures[index]
        val windSpeed = windSpeeds[index]
        val weathercode = weatherCodes[index]
        val pressure = pressures[index]
        val humiditie = humidities[index]

        indexWeatherData(
            index = index,
            weatherData = WeatherData(
                temperatureCelsius = temperature,
                time = LocalDateTime.parse(time , DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                pressure = pressure,
                humidity = humiditie,
                windSpeed = windSpeed,
                weatherType = WeatherType.fromWMO(weathercode)
            )
        )

    }.groupBy {
        it.index / 24
    }.mapValues { it ->
        it.value.map {
            it.weatherData
        }
    }
}


fun WeatherDto.toweatherinfo() : WeatherInfo{
    val weatherdatamap = weatherData.toweatehrDataMap()
    val time = LocalDateTime.now()
    val currentWeatherData = weatherdatamap[0]?.find {
        it.time.hour == time.hour
    }

    return WeatherInfo(
        weatherdatamap,
        currentWeatherData
    )
}