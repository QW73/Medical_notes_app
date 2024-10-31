package com.example.mydoctor.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [HealthDataModel::class], version = 1 )
//@TypeConverters(Converters::class)
abstract class HealthDB : RoomDatabase() {
    abstract fun healthDataDao(): HealthDataDao

    companion object {
        const val DATABASE_NAME = "health_data_db"
    }
}