package com.example.apphub.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.apphub.viewmodel.WeatherViewModel

@Composable
fun WeatherScreen(navController: NavHostController, viewModel: WeatherViewModel = viewModel()) {
    val weatherData by viewModel.weatherData.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = "Enter city name",
            onValueChange = { viewModel.fetchWeather(it) }
        )
        Spacer(modifier = Modifier.height(16.dp))

        weatherData?.let {
            Text(text = "City: ${it.cityName}", style = MaterialTheme.typography.titleMedium)
            Text(text = "Temperature: ${it.temperature}°C", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Description: ${it.description}", style = MaterialTheme.typography.bodyMedium)
        } ?: Text("Enter a city to get weather data")
    }
}
