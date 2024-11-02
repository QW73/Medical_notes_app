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

    /** Значения измерений. */
    var pulse by mutableStateOf("")
    var systolicBloodPressure by mutableStateOf("")
    var diastolicBloodPressure by mutableStateOf("")
    var dateOfMeasurement by mutableStateOf<LocalDate?>(null)
    var timeOfMeasurement by mutableStateOf("")
    var note by mutableStateOf("")

    /** Сообщение об ошибке, если запись не может быть сохранена. */
    var errorMessage by mutableStateOf<String?>(null)

    /** Состояние сохранения данных.*/
    var isDataSaved by mutableStateOf(false)

    /** Состояние активности кнопки сохранения данных. */
    val isSaveButtonEnabled: Boolean
        get() = systolicBloodPressure.isNotBlank() && diastolicBloodPressure.isNotBlank() && !isDataSaved

    /** Лист с историей данных измерений */
    private val healthDataList: StateFlow<List<HealthDataModel>> =
        repository.getHealthData().stateIn(viewModelScope, SharingStarted.Lazily, emptyList())


    init {
        observeHealthData()
    }


    /**
     * Сохраняет данные измерения в базе данных.
     */

    @RequiresApi(Build.VERSION_CODES.O)
    fun saveData() {
        /** Если дата или время пустые, подставляет текущие дату и время. */
        if (dateOfMeasurement == null || timeOfMeasurement.isBlank()) {
            if (dateOfMeasurement == null) {
                dateOfMeasurement = LocalDate.now()
            }
            if (timeOfMeasurement.isBlank()) {
                timeOfMeasurement = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))
            }
        } else {
            /** Если дата или время опережают текущие дату и время выводит сообщение о ошибке. */
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

        /**
         * Проверяет, чтобы дата и время не были больше текущих значений. Если данные с такими
         * параметрами уже существуют, выдает сообщение об ошибке.
         */
        viewModelScope.launch {
            isDataSaved = true
            if (isRecordExist()) {
                errorMessage = ("Запись с такими данными уже существует")
            } else {
                repository.insertHealthData(healthData)
            }
        }

    }


    /**
     * Наблюдает за изменениями в данных и логирует их.
     */
    private fun observeHealthData() {
        viewModelScope.launch {
            healthDataList.collectLatest { dataList ->
                dataList.forEach { data ->
                    Log.d(
                        "observeHealthData",
                        "Record: BP ${data.systolicBloodPressure}/${data.diastolicBloodPressure}, Pulse ${data.pulse}, Date ${data.dateOfMeasurement}, Time ${data.timeOfMeasurement}, Note: ${data.note}"
                    )
                }
            }
        }
    }


    /**
     * Проверяет, что дата и время измерения не превышают текущие значения.
     *
     * @return "true", если дата и время валидны; "false", если дата и время будущие.
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun isDateTimeValid(): Boolean {
        val currentDateTime = LocalDateTime.now()
        val inputDate = dateOfMeasurement ?: LocalDate.now()
        val inputTime = LocalTime.parse(timeOfMeasurement, DateTimeFormatter.ofPattern("HH:mm"))
        val inputDateTime = LocalDateTime.of(inputDate, inputTime)

        return inputDateTime.isBefore(currentDateTime) || inputDateTime.isEqual(currentDateTime)
    }

    /**
     * Проверяет, существует ли уже запись с такими же значениями.
     *
     * @return "true", если запись уже существует, иначе "false".
     */
    private suspend fun isRecordExist(): Boolean {
        return repository.isExist(systolicBloodPressure.toInt(),
            diastolicBloodPressure.toInt(),
            pulse.toIntOrNull() ?: 0,
            dateOfMeasurement!!,
            timeOfMeasurement,
            note.ifEmpty { null })
    }

    /**
     * Удаляет все данные из базы данных.
     */
    fun deleteData() {
        viewModelScope.launch {
            repository.deleteAllData()
        }
    }
}
