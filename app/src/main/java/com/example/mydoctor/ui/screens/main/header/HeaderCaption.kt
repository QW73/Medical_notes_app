package com.example.mydoctor.ui.screens.main.header

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mydoctor.R
import com.example.mydoctor.ui.theme.MainWhite
import com.example.mydoctor.ui.util.ScreenMetrics.figmaFontSizeToSp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaHeightToDp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaWidthToDp

@Composable
fun HeaderCaption(width: Float, height: Float, onAddClick: () -> Unit) {
    Box(
        modifier = Modifier
            .width(width.dp)
            .height(height.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ) {
            Text(
                text = stringResource(R.string.pressure),
                fontSize = figmaFontSizeToSp(18f),
                lineHeight = figmaHeightToDp(22f).sp,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )

            Spacer(modifier = Modifier.height(figmaHeightToDp(4f).dp))

            Text(
                text = stringResource(R.string.current_month),
                fontSize = figmaFontSizeToSp(14f),
                lineHeight = figmaHeightToDp(20f).sp,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }


        val addingIconSize = figmaHeightToDp(32f)

        Box(modifier = Modifier
            .width(addingIconSize.dp)
            .height(addingIconSize.dp)
            .clip(RoundedCornerShape(figmaWidthToDp(10f).dp))
            .background(MainWhite,
                shape = RoundedCornerShape(figmaWidthToDp(10f).dp))
            .clickable { onAddClick() }
            .align(Alignment.CenterEnd)

        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_adding),
                contentDescription = "Adding",
                modifier = Modifier
                    .size(figmaWidthToDp(16f).dp)
                    .align(Alignment.Center)
            )

        }
    }
}