package com.example.mydoctor.ui.screens.addData.data

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaFontSizeToSp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaHeightToDp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaWidthToDp

@Composable
fun Section(
    title: String,
    fields: List<FieldData>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(figmaHeightToDp(8f).dp)
    ) {
        Text(
            text = title,
            fontSize = figmaFontSizeToSp(16f),
            lineHeight = figmaHeightToDp(24f).sp,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(figmaWidthToDp(8f).dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            fields.forEach { field ->
                Field(
                    fieldData = field,
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
}