package com.example.mydoctor.ui.screens.addData.data.custom

import android.app.DatePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaFontSizeToSp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaHeightToDp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaWidthToDp
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun CustomDateField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    val dateFormatter = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

    val onDateClick = {
        DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance().apply {
                    set(year, month, dayOfMonth)
                }.time
                onValueChange(dateFormatter.format(selectedDate))
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(figmaWidthToDp(14f).dp)
            )
            .padding(
                horizontal = figmaWidthToDp(16f).dp, vertical = figmaHeightToDp(16f).dp
            )
            .clickable(onClick = onDateClick),
        contentAlignment = Alignment.CenterStart
    ) {
        if (value.isEmpty()) {
            Text(
                text = hint,
                style = TextStyle(
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = figmaFontSizeToSp(18f),
                    lineHeight = figmaHeightToDp(24f).sp
                )
            )
        } else {
            Text(
                text = value,
                style = TextStyle(
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = figmaFontSizeToSp(18f),
                    lineHeight = figmaHeightToDp(24f).sp
                )
            )
        }
    }
}