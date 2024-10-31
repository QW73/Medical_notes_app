package com.example.mydoctor.ui.screens

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mydoctor.data.db.HealthDataModel
import com.example.mydoctor.data.repo.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class AddDataViewModel @Inject constructor(
    private val repository: MainRepo
) : ViewModel() {

    var pulse by mutableStateOf("")
    var systolicBloodPressure by mutableStateOf("")
    var diastolicBloodPressure by mutableStateOf("")
    var dateOfMeasurement by mutableStateOf("")
    var timeOfMeasurement by mutableStateOf("")
    var note by mutableStateOf("")

    var errorMessage by mutableStateOf<String?>(null)

    private val healthDataList: StateFlow<List<HealthDataModel>> =
        repository.getHealthData().stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    val isSaveButtonEnabled: Boolean
        get() = systolicBloodPressure.isNotBlank() && diastolicBloodPressure.isNotBlank() && !isDataSaved

    var isDataSaved by mutableStateOf(false)

    init {
        observeHealthData()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun saveData() {


        val systolicBP = systolicBloodPressure.toIntOrNull()
        val diastolicBP = diastolicBloodPressure.toIntOrNull()
        val pulseValue = pulse.toIntOrNull()

        if (systolicBP == null || diastolicBP == null || pulseValue == null) {
            errorMessage =
                "Систолическое, диастолическое давление и пульс должны быть числовыми значениями"
            return
        }

        if (dateOfMeasurement.isBlank() || timeOfMeasurement.isBlank()) {
            if (dateOfMeasurement.isBlank()) {
                dateOfMeasurement =
                    LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
            }
            if (timeOfMeasurement.isBlank()) {
                timeOfMeasurement = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))
            }
        } else {
            if (!isDateTimeValid()) {
                errorMessage = "Дата и время не могут быть больше текущих"
                return
            }
        }

        val healthData =
            HealthDataModel(systolicBloodPressure = systolicBloodPressure.toIntOrNull() ?: 0,
                diastolicBloodPressure = diastolicBloodPressure.toIntOrNull() ?: 0,
                pulse = pulse.toIntOrNull() ?: 0,
                dateOfMeasurement = dateOfMeasurement,
                timeOfMeasurement = timeOfMeasurement,
                note = note.ifEmpty { null })

        viewModelScope.launch {
            isDataSaved = true
            if (isRecordExist()) {
                errorMessage = ("Запись с такими данными уже существует")
            } else {
                repository.insertHealthData(healthData)
            }
        }

    }

    private fun observeHealthData() {
        viewModelScope.launch {
            healthDataList.collectLatest { dataList ->
                dataList.forEach { data ->
                    Log.d(
                        "GetHealthDataViewModel",
                        "Record: BP ${data.systolicBloodPressure}/${data.diastolicBloodPressure}, Pulse ${data.pulse}, Date ${data.dateOfMeasurement}, Time ${data.timeOfMeasurement}, Note: ${data.note}"
                    )
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun isDateTimeValid(): Boolean {
        val currentDateTime = LocalDateTime.now()

        val inputDate =
            LocalDate.parse(dateOfMeasurement, DateTimeFormatter.ofPattern("dd.MM.yyyy"))
        val inputTime = LocalTime.parse(timeOfMeasurement, DateTimeFormatter.ofPattern("HH:mm"))
        val inputDateTime = LocalDateTime.of(inputDate, inputTime)

        return inputDateTime.isBefore(currentDateTime) || inputDateTime.isEqual(currentDateTime)
    }

    private suspend fun isRecordExist(): Boolean {
        return repository.isExist(systolicBloodPressure.toInt(),
            diastolicBloodPressure.toInt(),
            pulse.toIntOrNull() ?: 0,
            dateOfMeasurement,
            timeOfMeasurement,
            note.ifEmpty { null })
    }


    /* fun deleteData() {
         viewModelScope.launch {
             repository.deleteAllData()
         }
     }*/
}
