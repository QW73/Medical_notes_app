package com.example.mydoctor.data.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "health_data")
data class HealthDataModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val systolicBloodPressure: Int,
    val diastolicBloodPressure: Int,
    val pulse: Int?,
    val timeOfMeasurement: String?,
    val dateOfMeasurement: String?,
    val note: String?,
) : Parcelable