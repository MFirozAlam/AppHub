package com.example.apphub.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.material3.MaterialTheme


@Composable
fun CalculatorScreen(navController: NavHostController) {
    var displayText by remember { mutableStateOf("0") }
    var currentNumber by remember { mutableStateOf("") }
    var operator by remember { mutableStateOf<String?>(null) }
    var previousNumber by remember { mutableStateOf("") }

    // Functions to handle calculator operations
    val appendNumber: (String) -> Unit = { number ->
        currentNumber += number
        displayText = currentNumber
    }

    val setOperator: (String) -> Unit = { selectedOperator ->
        if (currentNumber.isNotEmpty()) {
            previousNumber = currentNumber
            currentNumber = ""
            operator = selectedOperator
        }
    }

    val clear: () -> Unit = {
        currentNumber = ""
        previousNumber = ""
        displayText = "0"
        operator = null
    }

    val calculateResult: () -> Unit = {
        val num1 = previousNumber.toDoubleOrNull()
        val num2 = currentNumber.toDoubleOrNull()

        if (num1 != null && num2 != null && operator != null) {
            val result = when (operator) {
                "+" -> num1 + num2
                "−" -> num1 - num2
                "×" -> num1 * num2
                "÷" -> if (num2 != 0.0) num1 / num2 else "Error"
                else -> "Error"
            }
            displayText = result.toString()
            previousNumber = result.toString()
            currentNumber = ""
            operator = null
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = displayText, style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(16.dp))

        Spacer(modifier = Modifier.height(16.dp))

        // Number pad and operations layout
        Column {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CalculatorButton("7") { appendNumber("7") }
                CalculatorButton("8") { appendNumber("8") }
                CalculatorButton("9") { appendNumber("9") }
                CalculatorButton("÷") { setOperator("÷") }
            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CalculatorButton("4") { appendNumber("4") }
                CalculatorButton("5") { appendNumber("5") }
                CalculatorButton("6") { appendNumber("6") }
                CalculatorButton("×") { setOperator("×") }
            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CalculatorButton("1") { appendNumber("1") }
                CalculatorButton("2") { appendNumber("2") }
                CalculatorButton("3") { appendNumber("3") }
                CalculatorButton("−") { setOperator("−") }
            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CalculatorButton("0") { appendNumber("0") }
                CalculatorButton("C") { clear() }
                CalculatorButton("=") { calculateResult() }
                CalculatorButton("+") { setOperator("+") }
            }
        }
    }
}

@Composable
fun CalculatorButton(symbol: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .size(64.dp)
            .padding(4.dp)
    ) {
        Text(text = symbol, style = MaterialTheme.typography.bodyLarge)
    }
}
