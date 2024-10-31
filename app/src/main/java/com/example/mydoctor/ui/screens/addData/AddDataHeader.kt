package com.example.mydoctor.ui.screens.addData

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
fun AddDataHeader(onAddClick: () -> Unit) {

    val headerHeight = figmaHeightToDp(40f)

    Column {

        Spacer(modifier = Modifier.height(figmaHeightToDp(22f).dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(headerHeight.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.add_data_header),
                fontSize = figmaFontSizeToSp(18f),
                lineHeight = figmaHeightToDp(22f).sp,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )

            Box(modifier = Modifier
                .clip(RoundedCornerShape(figmaWidthToDp(10f).dp))
                .background(MainWhite, shape = RoundedCornerShape(10.dp))
                .align(Alignment.CenterStart)
                .clickable { onAddClick() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "Adding",
                    modifier = Modifier
                        .size(figmaWidthToDp(32f).dp)
                        .align(Alignment.Center)
                )

            }
        }
    }


}