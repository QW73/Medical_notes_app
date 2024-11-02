package com.example.mydoctor.data.repo

import com.example.mydoctor.data.db.BloodPressureModel
import com.example.mydoctor.data.db.HealthDB
import com.example.mydoctor.data.db.HealthDataModel
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import javax.inject.Inject

class RepoImpl @Inject constructor(

    private val database: HealthDB,

    ) : MainRepo {
    override fun getHealthData(): Flow<List<HealthDataModel>> {

        return database.healthDataDao().getAllData()
    }

    override suspend fun insertHealthData(healthDataModel: HealthDataModel) {
        return database.healthDataDao().insertData(healthDataModel)
    }

    override suspend fun deleteAllData() {
        return database.healthDataDao().deleteAllData()
    }

    override suspend fun isExist(
        systolicBloodPressure: Int,
        diastolicBloodPressure: Int,
        pulse: Int,
        date: LocalDate,
        time: String,
        note: String?
    ): Boolean {
        return database.healthDataDao()
            .isExist(systolicBloodPressure, diastolicBloodPressure, pulse, date, time, note)
    }

    override suspend fun getDataForToday(currentDate: LocalDate): Flow<List<BloodPressureModel>> {
        return database.healthDataDao().getPressureDataForToday(currentDate)
    }

    override suspend fun getDataForPeriod(
        startDate: LocalDate, endDate: LocalDate
    ): Flow<List<BloodPressureModel>> {
        return database.healthDataDao().getPressureDataForPeriod(startDate, endDate)
    }

    override suspend fun getLastHealthData(
        currentDate: LocalDate, currentTime: String
    ): HealthDataModel? {
        return database.healthDataDao().getLastHealthData(currentDate, currentTime)
    }


}