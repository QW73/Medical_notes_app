package com.example.mydoctor.ui.util.blur

import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.mydoctor.ui.theme.RedBlur
import com.example.mydoctor.ui.theme.YellowBlur
import com.example.mydoctor.ui.util.ScreenMetrics.figmaHeightToDp

@Composable
fun Blur(level: Int) {

    val y1: Float
    val y2: Float

    when (level) {
        1 -> {
            y1 = 50f
            y2 = 32f
        }

        2 -> {
            y1 = (LocalConfiguration.current.screenHeightDp /14*7).toFloat()
            y2 = ((LocalConfiguration.current.screenHeightDp/14*7) -20).toFloat()
        }

        else -> {
            y1 = 0f
            y2 = 0f
        }
    }

    val redFlashSize = figmaHeightToDp(200f)
    val yellowFlashSize = figmaHeightToDp(340f)

    BlurredCircle(
        color = RedBlur, alpha = 0.4f, modifier = Modifier
            .absoluteOffset(
                x = LocalConfiguration.current.screenWidthDp.dp - (redFlashSize / 2).dp,
                y = figmaHeightToDp(y1).dp
            )
            .size(redFlashSize.dp)
    )

    BlurredCircle(
        color = YellowBlur, alpha = 0.7f, modifier = Modifier
            .absoluteOffset(
                x = LocalConfiguration.current.screenWidthDp.dp - (yellowFlashSize / 2).dp,
                y = figmaHeightToDp(y2).dp
            )
            .size(yellowFlashSize.dp)
    )
}