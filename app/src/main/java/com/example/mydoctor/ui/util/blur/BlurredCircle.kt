package com.example.mydoctor.ui.util.blur

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BlurredCircle(color: Color, alpha: Float, modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(color.copy(alpha = alpha), color.copy(alpha = 0f)),
                ), shape = CircleShape
            )
            .blur(radius = 100.dp)

    )
}