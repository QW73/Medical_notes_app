package com.example.mydoctor.ui.screens.addData

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mydoctor.R
import com.example.mydoctor.ui.screens.AddDataViewModel
import com.example.mydoctor.ui.screens.addData.data.FieldData
import com.example.mydoctor.ui.screens.addData.data.FieldType
import com.example.mydoctor.ui.screens.addData.data.Section
import com.example.mydoctor.ui.util.ScreenMetrics.figmaHeightToDp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaWidthToDp

@Composable
fun DataFields(modifier: Modifier = Modifier, viewModel: AddDataViewModel) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(figmaHeightToDp(24f).dp, Alignment.Top),
    ) {

        Row(
            horizontalArrangement = Arrangement.spacedBy(figmaWidthToDp(24f).dp),
        ) {
            Section(
                title = stringResource(R.string.blood_pressure), fields = listOf(
                    FieldData(
                        label = stringResource(R.string.graph_pressure_type_red),
                        hint = "120",
                        fieldType = FieldType.Text,
                        value = viewModel.systolicBloodPressure,
                        onValueChange = {
                            viewModel.systolicBloodPressure = it
                            viewModel.isDataSaved = false
                        }
                    ), FieldData(
                        label = stringResource(R.string.graph_pressure_type_yellow),
                        hint = "90",
                        fieldType = FieldType.Text,
                        value = viewModel.diastolicBloodPressure,
                        onValueChange = {
                            viewModel.diastolicBloodPressure = it
                            viewModel.isDataSaved = false
                        }
                    )
                ),
                modifier = Modifier.weight(2f)
            )
            Section(
                title = stringResource(R.string.pulse),
                fields = listOf(
                    FieldData(
                        label = stringResource(R.string.nothing),
                        hint = "70",
                        value = viewModel.pulse,
                        fieldType = FieldType.Text,
                        onValueChange = {
                            viewModel.pulse = it
                            viewModel.isDataSaved = false
                        }),
                ),
                modifier = Modifier.weight(1f),
            )
        }


        Row(
            horizontalArrangement = Arrangement.spacedBy(figmaWidthToDp(24f).dp),
        ) {
            Section(
                title = stringResource(R.string.date_of_measurement),
                fields = listOf(
                    FieldData(
                        hint = "27.06.2024",
                        fieldType = FieldType.Date,
                        value = viewModel.dateOfMeasurement,
                        onValueChange = {
                            viewModel.dateOfMeasurement = it
                            viewModel.isDataSaved = false
                        })
                ),
                modifier = Modifier.weight(1f)

            )
            Section(
                title = stringResource(R.string.time_of_measurement),
                fields = listOf(
                    FieldData(
                        hint = "17:00",
                        value = viewModel.timeOfMeasurement,
                        fieldType = FieldType.Time,
                        onValueChange = {
                            viewModel.timeOfMeasurement = it
                            viewModel.isDataSaved = false
                        }),
                ),
                modifier = Modifier.weight(1f)
            )
        }


        Row(
            horizontalArrangement = Arrangement.spacedBy(figmaWidthToDp(24f).dp),
        ) {
            Section(
                title = stringResource(R.string.note),
                fields = listOf(
                    FieldData(
                        hint = stringResource(R.string.note_adding),
                        value = viewModel.note,
                        fieldType = FieldType.Text,
                        onValueChange = {
                            viewModel.note = it
                            viewModel.isDataSaved = false
                        }),
                ),
                modifier = Modifier.weight(1f)
            )

        }

    }
}