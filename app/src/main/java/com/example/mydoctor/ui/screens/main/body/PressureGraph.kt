package com.example.mydoctor.ui.screens.main.body

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mydoctor.ui.screens.MainViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PressureGraph(modifier: Modifier = Modifier, width: Float, viewModel: MainViewModel) {

    LaunchedEffect(Unit) {
        viewModel.getLastData()
    }

    Column(
        modifier = modifier
            .width(width.dp)
            .height(120.dp)
            .background(Color.Green),

    ) {
        viewModel.bloodPressureData.forEach { bloodPressure ->
            Text(
                text = "Systolic: ${bloodPressure.first}, pulse ${bloodPressure.second}",
                color = Color.White
            )
        }
    }
}