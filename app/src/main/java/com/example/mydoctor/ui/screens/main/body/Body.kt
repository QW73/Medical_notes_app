package com.example.mydoctor.ui.screens.main.body

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mydoctor.ui.screens.MainViewModel
import com.example.mydoctor.ui.util.ScreenMetrics.figmaHeightToDp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaWidthToDp

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Body(modifier: Modifier = Modifier, viewModel: MainViewModel) {

    val padding = figmaHeightToDp(16f).dp
    val bodyComponentsWidth = figmaWidthToDp(341f)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(vertical = padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(padding)

    ) {
        FilterTab(modifier, bodyComponentsWidth, viewModel)
        Pressure(modifier, bodyComponentsWidth, viewModel)

        Notes(modifier, bodyComponentsWidth)


    }
}