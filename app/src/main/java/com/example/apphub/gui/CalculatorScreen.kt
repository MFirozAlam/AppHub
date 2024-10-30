package com.example.apphub.gui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apphub.viewmodel.BMICalculatorViewModel
import androidx.navigation.NavHostController

@Composable
fun BMICalculatorScreen(navController: NavHostController) {
    val viewModel: BMICalculatorViewModel = viewModel()
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = height,
            onValueChange = { height = it },
            label = { Text("Enter height (m)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = weight,
            onValueChange = { weight = it },
            label = { Text("Enter weight (kg)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val heightValue = height.toFloatOrNull()
                val weightValue = weight.toFloatOrNull()
                if (heightValue != null && weightValue != null) {
                    val bmiResult = viewModel.calculateBMI(heightValue, weightValue)
                    result = "BMI: ${bmiResult.bmi}, Category: ${bmiResult.category}"
                } else {
                    result = "Please enter valid values."
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculate BMI")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = result)
    }
}