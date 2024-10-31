package com.example.mydoctor.ui.screens

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mydoctor.data.repo.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepo
) : ViewModel() {

    var bloodPressureData by mutableStateOf<List<Pair<Int, Int>>>(emptyList())

    var lastSystolicBloodPressure by mutableStateOf<Int?>(null)
    var lastDiastolicBloodPressure by mutableStateOf<Int?>(null)
    var lastPulse by mutableStateOf<Int?>(null)
    var lastDate by mutableStateOf<String?>(null)

    @RequiresApi(Build.VERSION_CODES.O)
    fun getTodayData() {
        var today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
        viewModelScope.launch {
            repository.getDataForToday(today).collect { bloodPressureList ->
                bloodPressureData = bloodPressureList.map {
                    Pair(it.systolicBloodPressure, it.diastolicBloodPressure)
                }
            }
        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getLastData() {
        Log.d("MainViewModel", "getLastData called")
        val currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
        val currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))

        viewModelScope.launch {
            try {
                val lastHealthData = repository.getLastHealthData(currentDate, currentTime)

                lastHealthData?.let {
                    lastSystolicBloodPressure = it.systolicBloodPressure
                    lastDiastolicBloodPressure = it.diastolicBloodPressure
                    lastPulse = it.pulse
                    lastDate = it.dateOfMeasurement
                } ?: run {
                    lastSystolicBloodPressure = null
                    lastDiastolicBloodPressure = null
                    lastPulse = null
                    lastDate = null
                }
            } catch (e: Exception) {
                Log.e("Fetch last data", "Error fetching last health data", e)
            }
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun getWeekData() {
        val endDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
        val startDate =
            LocalDate.now().minusDays(7).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))

        viewModelScope.launch {
            repository.getDataForPeriod(startDate, endDate).collect { bloodPressure ->
                bloodPressureData = bloodPressure.map {
                    Pair(it.systolicBloodPressure, it.diastolicBloodPressure)
                }
            }
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun getMonthData() {
        val endDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
        val startDate = LocalDate.now().minusMonths(1).withDayOfMonth(1)
            .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))

        viewModelScope.launch {
            repository.getDataForPeriod(startDate, endDate).collect { bloodPressure ->
                bloodPressureData = bloodPressure.map {
                    Pair(it.systolicBloodPressure, it.diastolicBloodPressure)
                }
            }

        }
    }
}


