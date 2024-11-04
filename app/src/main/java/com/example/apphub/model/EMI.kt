package com.example.apphub.model

data class EMI(
    val principal: Float,
    val rate: Float,
    val tenure: Int,
    val monthlyEMI: Float
)
