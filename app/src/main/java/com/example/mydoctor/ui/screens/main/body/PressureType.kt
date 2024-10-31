package com.example.mydoctor.ui.screens.main.body

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mydoctor.R
import com.example.mydoctor.ui.theme.AccentRed
import com.example.mydoctor.ui.theme.AccentYellow
import com.example.mydoctor.ui.util.ScreenMetrics.figmaFontSizeToSp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaHeightToDp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaWidthToDp


@Composable
fun PressureType(modifier: Modifier = Modifier, width: Float) {

    Row(
        modifier = modifier
            .width(width.dp),
        horizontalArrangement = Arrangement.spacedBy(figmaWidthToDp(16f).dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Box(
            modifier = Modifier
                .size(figmaWidthToDp(8f).dp)
                .clip(CircleShape)
                .background(AccentRed)
        )

        Text(
            text = stringResource(R.string.graph_pressure_type_red),
            fontSize = figmaFontSizeToSp(12f),
            lineHeight = figmaHeightToDp(16f).sp,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )

        Box(
            modifier = Modifier
                .size(figmaWidthToDp(8f).dp)
                .clip(CircleShape)
                .background(AccentYellow)
        )

        Text(
            text = stringResource(R.string.graph_pressure_type_yellow),
            fontSize = figmaFontSizeToSp(12f),
            lineHeight = figmaHeightToDp(16f).sp,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}