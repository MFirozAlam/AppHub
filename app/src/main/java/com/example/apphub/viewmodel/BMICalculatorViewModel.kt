package com.example.apphub.viewmodel

import androidx.lifecycle.ViewModel

class BMICalculatorViewModel : ViewModel() {

    data class BMIResult(val bmi: Float, val category: String)

    fun calculateBMI(height: Float, weight: Float): BMIResult {
        val bmi = weight / (height * height)
        val category = when {
            bmi < 18.5 -> "Underweight"
            bmi < 24.9 -> "Normal weight"
            bmi < 29.9 -> "Overweight"
            else -> "Obese"
        }
        return BMIResult(bmi, category)
    }
}
