package com.example.apphub.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apphub.model.WeatherData
import com.example.apphub.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val _weatherData = MutableStateFlow<WeatherData?>(null)
    val weatherData: StateFlow<WeatherData?> get() = _weatherData

    fun fetchWeather(city: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getWeather(city, apiKey = "G-31TSX35RJT")
                if (response.isSuccessful) {
                    response.body()?.let {
                        _weatherData.value = WeatherData(
                            temperature = it.main.temp,
                            description = it.weather[0].description,
                            cityName = it.name
                        )
                    }
                }
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
