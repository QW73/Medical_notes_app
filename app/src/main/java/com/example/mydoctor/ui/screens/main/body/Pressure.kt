package com.example.mydoctor.ui.screens.main.body

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mydoctor.ui.screens.MainViewModel
import com.example.mydoctor.ui.util.ScreenMetrics.figmaHeightToDp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaWidthToDp

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Pressure(modifier: Modifier = Modifier, width: Float,  viewModel: MainViewModel) {

    Column(
        modifier = modifier
            .width(width.dp)
            .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(24.dp))
            .padding(vertical = figmaHeightToDp(24f).dp, horizontal = figmaWidthToDp(16f).dp),
        verticalArrangement = Arrangement.spacedBy(figmaWidthToDp(16f).dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        GraphData(modifier, width, false, viewModel)

        HorizontalDivider(
            color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.3f),
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
        )

        PressureType(modifier, width)

        PressureGraph(modifier, width, viewModel)

        PressureAddButton(modifier, width)
    }
}