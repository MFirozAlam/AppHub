package com.example.apphub.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.apphub.gui.HomeScreen
import com.example.apphub.screens.*
import com.example.apphub.viewmodel.QuotesViewModel
import com.example.apphub.viewmodel.ToDoViewModel

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.BMI.route) { BMICalculatorScreen(navController) }
        composable(Screen.Calculator.route) { CalculatorScreen(navController) }
        composable(Screen.Gaming.route) { GamingAppCloneScreen(navController) }
        composable(Screen.News.route) { NewsScreen(navController) }
        composable(Screen.Quotes.route) {
            val quotesViewModel: QuotesViewModel = viewModel()
            QuotesGeneratingScreen(viewModel = quotesViewModel)
        }
        composable(Screen.ToDo.route) {
            val toDoViewModel: ToDoViewModel = viewModel()
            ToDoListScreen(viewModel = toDoViewModel)
        }
        composable(Screen.Weather.route) { WeatherScreen(navController) }
        composable(Screen.EMI.route) { EMICalculatorScreen(navController) }
    }
}
