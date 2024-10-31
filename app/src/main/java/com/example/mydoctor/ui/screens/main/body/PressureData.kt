package com.example.mydoctor.ui.screens.main.body

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mydoctor.R
import com.example.mydoctor.ui.screens.MainViewModel
import com.example.mydoctor.ui.util.ScreenMetrics.figmaFontSizeToSp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaHeightToDp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaWidthToDp

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun GraphData(
    modifier: Modifier = Modifier, width: Float, hasData: Boolean, viewModel: MainViewModel
) {

    LaunchedEffect(Unit) {
        viewModel.getLastData()
    }

    if (viewModel.lastSystolicBloodPressure != null && viewModel.lastDiastolicBloodPressure != null) {
        Column(
            verticalArrangement = Arrangement.spacedBy(figmaWidthToDp(16f).dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "${viewModel.lastSystolicBloodPressure}/${viewModel.lastDiastolicBloodPressure} pulse ${viewModel.lastPulse}",
                fontSize = figmaFontSizeToSp(18f),
                lineHeight = figmaHeightToDp(24f).sp,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onTertiary
            )
            Text(
                text = "${viewModel.lastDate}",
                modifier = modifier.width(width.dp),
                fontSize = figmaFontSizeToSp(10f),
                lineHeight = figmaHeightToDp(16f).sp,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

    } else {
        Column(
            verticalArrangement = Arrangement.spacedBy(figmaWidthToDp(16f).dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = stringResource(R.string.pressure_no_data),
                fontSize = figmaFontSizeToSp(18f),
                lineHeight = figmaHeightToDp(24f).sp,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onTertiary
            )
            Text(
                text = stringResource(R.string.pressure_data_period),
                modifier = modifier.width(width.dp),
                fontSize = figmaFontSizeToSp(10f),
                lineHeight = figmaHeightToDp(16f).sp,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }


}