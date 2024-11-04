package com.example.apphub.viewmodel

import androidx.lifecycle.ViewModel
import com.example.apphub.model.EMI
import kotlin.math.pow

class EMICalculatorViewModel : ViewModel() {
    fun calculateEMI(principal: Float, rate: Float, tenure: Int): EMI {
        val monthlyRate = rate / (12 * 100)
        val emi = (principal * monthlyRate * (1 + monthlyRate).pow(tenure * 12)) /
                ((1 + monthlyRate).pow(tenure * 12) - 1)
        return EMI(principal, rate, tenure, emi)
    }
}
