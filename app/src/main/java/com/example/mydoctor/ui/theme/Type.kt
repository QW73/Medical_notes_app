package com.example.mydoctor.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaFontSizeToSp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 0.5.sp,
        ),

    bodyMedium =
    TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.5.sp,
        ),


    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)


val LogoTypography = TextStyle(
    fontFamily = Exo2,
    fontWeight = FontWeight.SemiBold,
    fontSize = figmaFontSizeToSp(16f),
    )
