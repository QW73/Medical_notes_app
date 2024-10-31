package com.example.mydoctor.data

import android.content.Context
import androidx.room.Room.databaseBuilder
import com.example.mydoctor.data.db.HealthDB
import com.example.mydoctor.data.db.HealthDataDao
import com.example.mydoctor.data.repo.MainRepo
import com.example.mydoctor.data.repo.RepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideHealthDatabase(@ApplicationContext context: Context): HealthDB =
        databaseBuilder(context, HealthDB::class.java, HealthDB.DATABASE_NAME).build()

    @Provides
    fun provideHealthDataDao(database: HealthDB): HealthDataDao {
        return database.healthDataDao()
    }

    @Provides
    @Singleton
    fun provideRepositoryHelper(repository: RepoImpl): MainRepo = repository

}