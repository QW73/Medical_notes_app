package com.example.mydoctor.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

const val FIGMA_SCREEN_WIDTH = 375f
const val FIGMA_SCREEN_HEIGHT = 858f

object ScreenMetrics {
    private var widthScale: Float = 1f
    private var heightScale: Float = 1f

    @Composable
    fun initialize() {
        val configuration = LocalConfiguration.current
        val screenWidth = configuration.screenWidthDp.toFloat()
        val screenHeight = configuration.screenHeightDp.toFloat()

        widthScale = screenWidth / FIGMA_SCREEN_WIDTH
        heightScale = screenHeight / FIGMA_SCREEN_HEIGHT
    }

    fun figmaWidthToDp(width: Float): Float {
        return width * widthScale
    }

    fun figmaHeightToDp(height: Float): Float {
        return height * heightScale
    }

    fun figmaToDp(width: Float, height: Float): Pair<Float, Float> {
        return Pair(width * widthScale, height * heightScale)
    }

    fun figmaFontSizeToSp(size: Float): TextUnit {
        return (size * heightScale).sp
    }
}