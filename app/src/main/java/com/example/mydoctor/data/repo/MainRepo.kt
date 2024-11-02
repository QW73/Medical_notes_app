package com.example.mydoctor.data.repo

import com.example.mydoctor.data.db.BloodPressureModel
import com.example.mydoctor.data.db.HealthDataModel
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface MainRepo {

    fun getHealthData(): Flow<List<HealthDataModel>>
    suspend fun insertHealthData(healthDataModel: HealthDataModel)
    suspend fun deleteAllData()
    suspend fun isExist(
        systolicBloodPressure: Int,
        diastolicBloodPressure: Int,
        pulse: Int,
        date: LocalDate,
        time: String,
        note: String?,
    ): Boolean

    suspend fun getDataForToday(currentDate: LocalDate): Flow<List<BloodPressureModel>>
    suspend fun getDataForPeriod(startDate: LocalDate, endDate: LocalDate): Flow<List<BloodPressureModel>>

    suspend fun getLastHealthData(currentDate: LocalDate, currentTime: String): HealthDataModel?

}