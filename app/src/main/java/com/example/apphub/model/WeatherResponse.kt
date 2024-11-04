package com.example.apphub.model

data class WeatherResponse(
    val main: Main,
    val weather: List<WeatherCondition>,
    val name: String
)

data class Main(val temp: Float)
data class WeatherCondition(val description: String)
