package com.example.mydoctor.ui.screens.addData.data


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mydoctor.ui.screens.addData.data.custom.CustomDateField
import com.example.mydoctor.ui.screens.addData.data.custom.CustomTextField
import com.example.mydoctor.ui.screens.addData.data.custom.CustomTimeField
import com.example.mydoctor.ui.util.ScreenMetrics.figmaFontSizeToSp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaHeightToDp

@Composable
fun Field(
    fieldData: FieldData,
    modifier: Modifier = Modifier
) {


    Column(
        verticalArrangement = Arrangement.spacedBy(figmaHeightToDp(16f).dp),
        modifier = modifier
    ) {
        fieldData.label?.let {
            Text(
                text = it,
                fontSize = figmaFontSizeToSp(12f),
                lineHeight = figmaHeightToDp(16f).sp,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
            )
        } ?: fieldData.title?.let {
            Text(
                text = it,
                fontSize = figmaFontSizeToSp(16f),
                lineHeight = figmaHeightToDp(24f).sp,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

        when (fieldData.fieldType) {
            FieldType.Text -> {
                CustomTextField(
                    value = fieldData.value,
                    onValueChange = fieldData.onValueChange,
                    hint = fieldData.hint,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            FieldType.Date -> {
                CustomDateField(
                    value = fieldData.value,
                    onValueChange = fieldData.onValueChange,
                    hint = fieldData.hint,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            FieldType.Time -> {
                CustomTimeField(
                    value = fieldData.value,
                    onValueChange = fieldData.onValueChange,
                    hint = fieldData.hint,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}







