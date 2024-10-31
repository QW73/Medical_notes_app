package com.example.mydoctor.ui.screens.main.body

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mydoctor.R
import com.example.mydoctor.ui.util.ScreenMetrics.figmaFontSizeToSp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaHeightToDp

@Composable
fun NotesData(modifier: Modifier = Modifier, width: Float, hasData: Boolean) {

    if (!hasData) {
        Column(
            modifier = modifier
            .padding(vertical = figmaHeightToDp(8f).dp),

        verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = stringResource(R.string.notes_no_data),

                fontSize = figmaFontSizeToSp(14f),
                lineHeight = figmaHeightToDp(20f).sp,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

        }

    } else {
        //if data exist
    }
}