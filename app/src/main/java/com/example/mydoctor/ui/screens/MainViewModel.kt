package com.example.mydoctor.ui.screens

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mydoctor.data.db.BloodPressureModel
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

    /** Данные артериального давления за выбранный период. */
    var bloodPressureData by mutableStateOf<List<BloodPressureModel>>(emptyList())

    /** Последние добавленные значения измерений. */
    var lastSystolicBloodPressure by mutableStateOf<Int?>(null)
    var lastDiastolicBloodPressure by mutableStateOf<Int?>(null)
    var lastPulse by mutableStateOf<Int?>(null)
    var lastDate by mutableStateOf<String?>(null)


    /**
     * Получает данные давления, записанные сегодня, используя текущую дату для запроса.
     *
     * Обновляет "bloodPressureData".
     */

    @RequiresApi(Build.VERSION_CODES.O)
    fun getTodayData() {
        val today = LocalDate.now()
        viewModelScope.launch {
            repository.getDataForToday(today).collect { bloodPressure ->
                bloodPressureData = bloodPressure.map {
                    BloodPressureModel(
                        systolicBloodPressure = it.systolicBloodPressure,
                        diastolicBloodPressure = it.diastolicBloodPressure,
                        dateOfMeasurement = it.dateOfMeasurement,
                        timeOfMeasurement = it.timeOfMeasurement,
                    )
                }
            }

        }
    }


    /**
     * Получает последние данные давления, используя текущую дату и время.
     *
     * Сохраняет полученные значения в переменные "lastSystolicBloodPressure",
     * "lastDiastolicBloodPressure", "lastPulse" и "lastDate".
     *
     * При возникновении ошибки логирует её.
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun getLastData() {
        val currentDate = LocalDate.now()
        val currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))

        viewModelScope.launch {
            try {
                val lastHealthData = repository.getLastHealthData(currentDate, currentTime)
                lastHealthData?.let {
                    lastSystolicBloodPressure = it.systolicBloodPressure
                    lastDiastolicBloodPressure = it.diastolicBloodPressure
                    lastPulse = it.pulse
                    lastDate = it.dateOfMeasurement.toString()
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

    /**
     * Получает данные давления за последние 7 дней и обновляет "bloodPressureData".
     *
     * Использует текущую дату и дату за 7 дней назад для запроса данных.
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun getWeekData() {
        val endDate = LocalDate.now()
        val startDate = LocalDate.now().minusDays(7)
        Log.d("getWeekData", "Fetching data from $startDate to $endDate")

        viewModelScope.launch {
            repository.getDataForPeriod(startDate, endDate).collect { bloodPressure ->
                Log.d("getWeekData", "Received ${bloodPressure.size} entries")
                bloodPressureData = bloodPressure.map {
                    BloodPressureModel(
                        systolicBloodPressure = it.systolicBloodPressure,
                        diastolicBloodPressure = it.diastolicBloodPressure,
                        dateOfMeasurement = it.dateOfMeasurement,
                        timeOfMeasurement = it.timeOfMeasurement,
                    )
                }
            }

        }
    }

    /**
     * Получает данные давления за последний месяц и обновляет "bloodPressureData".
     *
     * Использует текущую дату и первую дату прошлого месяца для запроса данных.
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun getMonthData() {
        val endDate = LocalDate.now()
        val startDate = LocalDate.now().minusMonths(1).withDayOfMonth(1)

        viewModelScope.launch {
            repository.getDataForPeriod(startDate, endDate).collect { bloodPressure ->
                Log.d("getMonthData", "Received ${bloodPressure.size} entries")
                bloodPressureData = bloodPressure.map {
                    BloodPressureModel(
                        systolicBloodPressure = it.systolicBloodPressure,
                        diastolicBloodPressure = it.diastolicBloodPressure,
                        dateOfMeasurement = it.dateOfMeasurement,
                        timeOfMeasurement = it.timeOfMeasurement,
                    )
                }
            }

        }
    }
}



