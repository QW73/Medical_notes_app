package com.example.mydoctor.data.db

data class BloodPressureModel(
    val systolicBloodPressure: Int,
    val diastolicBloodPressure: Int,
    val timeOfMeasurement: String,
    val dateOfMeasurement: String,
)