package com.example.apphub.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object BMI : Screen("bmi")
    object Calculator : Screen("calculator")
    object Gaming : Screen("gaming")
    object News : Screen("news")
    object Quotes : Screen("quotes")
    object ToDo : Screen("todo")
    object Weather : Screen("weather")
    object EMI : Screen("emi")
}
