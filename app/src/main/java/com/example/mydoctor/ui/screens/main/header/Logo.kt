package com.example.mydoctor.ui.screens.main.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mydoctor.R
import com.example.mydoctor.ui.theme.LogoTypography
import com.example.mydoctor.ui.util.ScreenMetrics.figmaWidthToDp

@Composable
fun Logo(width: Float, height: Float) {

    Row(
        modifier = Modifier
            .width(width.dp)
            .height(height.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {

        val iconBoxWidth = figmaWidthToDp(45f).dp
        val iconSize = figmaWidthToDp(32f).dp

        Box(
            modifier = Modifier
                .width(iconBoxWidth)
                .fillMaxHeight(),
            Alignment.Center
        )
        {
            Icon(
                painter = painterResource(id = R.drawable.ic_app_icon),
                contentDescription = "App Icon",
                modifier = Modifier.size(iconSize)
            )
        }

        Spacer(modifier = Modifier.width(figmaWidthToDp(6f).dp))

        Text(
            text = "Мой доктор", style = LogoTypography, color = MaterialTheme.colorScheme.onPrimary
        )

    }

}