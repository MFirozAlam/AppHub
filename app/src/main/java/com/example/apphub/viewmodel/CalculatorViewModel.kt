package com.example.apphub.viewmodel

import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    // Function to add two numbers
    fun add(a: Double, b: Double): Double {
        return a + b
    }

    // Function to subtract two numbers
    fun subtract(a: Double, b: Double): Double {
        return a - b
    }

    // Function to multiply two numbers
    fun multiply(a: Double, b: Double): Double {
        return a * b
    }

    // Function to divide two numbers with error handling for division by zero
    fun divide(a: Double, b: Double): Double {
        return if (b != 0.0) {
            a / b
        } else {
            Double.NaN // Return NaN if dividing by zero
        }
    }
}
