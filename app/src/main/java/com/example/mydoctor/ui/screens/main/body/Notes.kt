package com.example.mydoctor.ui.screens.main.body

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mydoctor.R
import com.example.mydoctor.ui.util.ScreenMetrics.figmaFontSizeToSp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaHeightToDp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaWidthToDp

@Composable
fun Notes(modifier: Modifier = Modifier, width: Float) {

    Column(
        modifier = modifier
            .width(width.dp)
            .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(24.dp))
            .padding(vertical = figmaHeightToDp(24f).dp, horizontal = figmaWidthToDp(16f).dp),
        verticalArrangement = Arrangement.spacedBy(figmaWidthToDp(8f).dp),
        horizontalAlignment = Alignment.Start

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(figmaWidthToDp(16f).dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_edit),
                contentDescription = "Edit Note Icon",
                modifier = Modifier.size(figmaWidthToDp(24f).dp),
                tint = Color.Unspecified
            )

            Text(
                text = stringResource(R.string.notes),
                fontSize = figmaFontSizeToSp(16f),
                lineHeight = figmaHeightToDp(24f).sp,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onTertiary,
                modifier = Modifier.weight(1f)
            )
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.ic_plus),
                    contentDescription = "Plus Icon",
                    modifier = Modifier
                        .size(figmaWidthToDp(18f).dp)
                )
                Spacer(modifier = Modifier.width(figmaWidthToDp(6f).dp))
            }
        }

        HorizontalDivider(
            color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.3f),
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
        )

        NotesData(modifier, width, false)

    }
}