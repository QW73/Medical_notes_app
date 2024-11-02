package com.example.mydoctor.ui.screens.addData.data.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaFontSizeToSp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaHeightToDp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaWidthToDp

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(figmaWidthToDp(14f).dp)
            )
            .padding(
                horizontal = figmaWidthToDp(16f).dp, vertical = figmaHeightToDp(16f).dp
            ), contentAlignment = Alignment.CenterStart
    ) {
        BasicTextField(
            value = value,
            onValueChange = { newValue ->
                if (newValue.all { it.isDigit() } || newValue.isEmpty()) {
                    onValueChange(newValue)
                }
            },
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = figmaFontSizeToSp(18f),
                lineHeight = figmaHeightToDp(24f).sp
            ),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.onPrimary),
            decorationBox = { innerTextField ->
                if (value.isEmpty()) {
                    Text(
                        text = hint, style = TextStyle(
                            color = MaterialTheme.colorScheme.onSurface,
                            fontSize = figmaFontSizeToSp(18f),
                            lineHeight = figmaHeightToDp(24f).sp
                        )
                    )
                }
                innerTextField()
            },
            singleLine = true,
        )
    }
}
