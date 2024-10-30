package com.example.apphub.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlin.math.pow

@Composable
fun EMICalculatorScreen(navController: NavHostController) {
    var principal by remember { mutableStateOf(TextFieldValue("")) }
    var interestRate by remember { mutableStateOf(TextFieldValue("")) }
    var tenure by remember { mutableStateOf(TextFieldValue("")) }
    var emiResult by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text("EMI Calculator", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = principal,
            onValueChange = { principal = it },
            label = { Text("Principal Amount (₹)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = interestRate,
            onValueChange = { interestRate = it },
            label = { Text("Annual Interest Rate (%)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = tenure,
            onValueChange = { tenure = it },
            label = { Text("Loan Tenure (years)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val principalAmount = principal.text.toDoubleOrNull()
                val rate = interestRate.text.toDoubleOrNull()
                val years = tenure.text.toIntOrNull()

                if (principalAmount != null && rate != null && years != null) {
                    emiResult = calculateEMI(principalAmount, rate, years)
                } else {
                    emiResult = "Please enter valid inputs"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculate EMI")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = emiResult, style = MaterialTheme.typography.bodyMedium)
    }
}

fun calculateEMI(principal: Double, annualRate: Double, years: Int): String {
    val monthlyRate = (annualRate / 12) / 100
    val months = years * 12
    val emi = (principal * monthlyRate * (1 + monthlyRate).pow(months)) / ((1 + monthlyRate).pow(months) - 1)
    return "Your EMI is ₹${String.format("%.2f", emi)} per month"
}
@Preview(showBackground = true)
@Composable
fun PreviewEMICalculatorScreen() {
    EMICalculatorScreen(navController = rememberNavController())
}
