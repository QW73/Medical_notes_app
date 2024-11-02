package com.example.mydoctor.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@Dao
interface HealthDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(healthData: HealthDataModel)

    @Query("DELETE FROM health_data")
    suspend fun deleteAllData()

    @Query("SELECT * FROM health_data ORDER BY dateOfMeasurement DESC")
    fun getAllData(): Flow<List<HealthDataModel>>

    @Query("SELECT COUNT(*) > 0 FROM health_data WHERE systolicBloodPressure = :systolicBloodPressure AND diastolicBloodPressure = :diastolicBloodPressure AND pulse = :pulse AND dateOfMeasurement = :date AND timeOfMeasurement = :time  AND (note = :note OR (:note IS NULL AND note IS NULL))    LIMIT 1")
    suspend fun isExist(
        systolicBloodPressure: Int,
        diastolicBloodPressure: Int,
        pulse: Int,
        date: LocalDate,
        time: String,
        note: String?,
    ): Boolean


    @Query("SELECT systolicBloodPressure, diastolicBloodPressure, dateOfMeasurement, timeOfMeasurement FROM health_data WHERE dateOfMeasurement = :currentDate ORDER BY dateOfMeasurement DESC")
    fun getPressureDataForToday(currentDate: LocalDate): Flow<List<BloodPressureModel>>

    @Query(
        """
    SELECT systolicBloodPressure, diastolicBloodPressure, dateOfMeasurement, timeOfMeasurement
    FROM health_data
    WHERE dateOfMeasurement BETWEEN :startDate AND :endDate
    ORDER BY dateOfMeasurement DESC
"""
    )
    fun getPressureDataForPeriod(startDate: LocalDate, endDate: LocalDate): Flow<List<BloodPressureModel>>

    @Query(
        """
    SELECT * FROM health_data 
    WHERE dateOfMeasurement <= :currentDate 
    AND timeOfMeasurement <= :currentTime
    ORDER BY dateOfMeasurement DESC , timeOfMeasurement DESC  
    LIMIT 1
"""
    )
    suspend fun getLastHealthData(currentDate: LocalDate, currentTime: String): HealthDataModel?
}



