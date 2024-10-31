package com.example.mydoctor.data.repo

import com.example.mydoctor.data.db.BloodPressureModel
import com.example.mydoctor.data.db.HealthDataModel
import kotlinx.coroutines.flow.Flow

interface MainRepo {

    fun getHealthData(): Flow<List<HealthDataModel>>
    suspend fun insertHealthData(healthDataModel: HealthDataModel)
    suspend fun deleteAllData()
    suspend fun isExist(
        systolicBloodPressure: Int,
        diastolicBloodPressure: Int,
        pulse: Int,
        date: String,
        time: String,
        note: String?,
    ): Boolean

    suspend fun getDataForToday(currentDate: String): Flow<List<BloodPressureModel>>
    suspend fun getDataForPeriod(startDate: String, endDate: String): Flow<List<BloodPressureModel>>

    suspend fun getLastHealthData(currentDate: String, currentTime: String): HealthDataModel?
}