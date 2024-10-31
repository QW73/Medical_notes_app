package com.example.mydoctor.ui.screens.main.body

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mydoctor.R
import com.example.mydoctor.ui.theme.AccentRed
import com.example.mydoctor.ui.util.ScreenMetrics.figmaFontSizeToSp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaHeightToDp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaWidthToDp


@Composable
fun PressureAddButton(modifier: Modifier = Modifier, width: Float) {
    Column(
        modifier = modifier.width(width.dp), horizontalAlignment = Alignment.End
    ) {
        Box(
            modifier = modifier
                .border(
                    width = 1.dp,
                    color = AccentRed,
                    shape = RoundedCornerShape(figmaWidthToDp(16f).dp)
                )
                .padding(vertical = figmaHeightToDp(8f).dp, horizontal = figmaWidthToDp(16f).dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.graph_pressure_add_data),
                fontSize = figmaFontSizeToSp(12f),
                lineHeight = figmaHeightToDp(16f).sp,
                style = MaterialTheme.typography.bodyMedium,
                color = AccentRed
            )
        }
    }
}
