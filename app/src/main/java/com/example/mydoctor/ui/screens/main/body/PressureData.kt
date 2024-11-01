package com.example.mydoctor.ui.screens.main.body

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(figmaWidthToDp(8f).dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(figmaWidthToDp(8f).dp),
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    text =  stringResource(R.string.pressure),
                    fontSize = figmaFontSizeToSp(12f),
                    lineHeight = figmaHeightToDp(16f).sp,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)

                )
                Text(
                    text = "${viewModel.lastSystolicBloodPressure}/${viewModel.lastDiastolicBloodPressure}",
                    fontSize = figmaFontSizeToSp(18f),
                    lineHeight = figmaHeightToDp(24f).sp,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onTertiary
                )
                Text(
                    text = stringResource(R.string.pressure_units),
                    fontSize = figmaFontSizeToSp(12f),
                    lineHeight = figmaHeightToDp(16f).sp,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(figmaWidthToDp(8f).dp),
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    text =  stringResource(R.string.pulse),
                    fontSize = figmaFontSizeToSp(12f),
                    lineHeight = figmaHeightToDp(16f).sp,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)

                )
                Text(
                    text = "${viewModel.lastPulse}",
                    fontSize = figmaFontSizeToSp(18f),
                    lineHeight = figmaHeightToDp(24f).sp,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onTertiary
                )
                Text(
                    text = stringResource(R.string.pulse_units),
                    fontSize = figmaFontSizeToSp(12f),
                    lineHeight = figmaHeightToDp(16f).sp,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
                )
            }

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