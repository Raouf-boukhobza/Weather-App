package com.plcoding.weatherapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.weatherapp.domain.Location.LocationTracker
import com.plcoding.weatherapp.domain.repository.WeatherRepository
import com.plcoding.weatherapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject



class WeatherViewModel (
    private val weatherRepository: WeatherRepository,
    private val locationTracker: LocationTracker
) : ViewModel() {

    var weatherState by mutableStateOf(WeatherState())
        private set

    fun loadWeatherInfo() {
        viewModelScope.launch {
            weatherState = weatherState.copy(
                isLoading = true,
            )

            locationTracker.getLocation()?.let { location ->
                val result = weatherRepository.getWeatherInfo(location.latitude , location.longitude)

                when(result){
                    is Resource.Error -> {
                        weatherState = weatherState.copy(
                            isLoading = false,
                            weatherInfo = null,
                            error = result.message
                        )

                    }
                    is Resource.Success -> {
                        weatherState = weatherState.copy(
                            weatherInfo = result.data,
                            isLoading = false,
                            error = null
                        )
                    }
                }
            } ?: kotlin.run {
                weatherState = weatherState.copy(
                    error = "Couldn't retrieve Location",
                    isLoading = false
                )
            }
        }
    }

}