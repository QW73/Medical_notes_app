package com.example.mydoctor.ui.screens.main.body

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mydoctor.R
import com.example.mydoctor.ui.screens.MainViewModel
import com.example.mydoctor.ui.util.ScreenMetrics.figmaFontSizeToSp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaHeightToDp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaWidthToDp

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FilterTab(modifier: Modifier = Modifier, width: Float, viewModel: MainViewModel) {

    val filterTabHeight = figmaHeightToDp(46f).dp // !! Тут изменила

    val options = listOf(
        stringResource(R.string.tab_day),
        stringResource(R.string.tab_week),
        stringResource(id = R.string.tab_month)
    )

    var selectedOption: String by remember { mutableStateOf(options[0]) }

    LaunchedEffect(Unit) {
        viewModel.getTodayData()
    }

    Row(
        modifier = modifier
            .width(width.dp)
            .height(filterTabHeight)
            .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(8.dp))
            .padding(vertical = figmaHeightToDp(8f).dp, horizontal = figmaWidthToDp(16f).dp),
        horizontalArrangement = Arrangement.spacedBy(figmaWidthToDp(6f).dp),
        verticalAlignment = Alignment.CenterVertically

    ) {

        options.forEach { option ->
            FilterButton(
                text = option,
                isSelected = option == selectedOption,
                onClick = {
                    selectedOption = option
                    when (option) {
                        options[0] -> viewModel.getTodayData()
                        options[1] -> viewModel.getWeekData()
                        options[2] -> viewModel.getMonthData()
                    }
                },
                modifier = Modifier.weight(1f)
            )
        }
    }
}


@Composable
fun FilterButton(
    text: String, isSelected: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier
) {

    val backgroundColor =
        if (isSelected) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary

    val textStyle =
        if (isSelected) MaterialTheme.typography.bodyLarge else MaterialTheme.typography.bodyMedium

    Box(
        modifier = modifier
            .fillMaxHeight()
            .clip(RoundedCornerShape(figmaWidthToDp(24f).dp))
            .clickable(
                onClick = onClick
            )
            .background(
                backgroundColor,
                shape = RoundedCornerShape(figmaWidthToDp(24f).dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = figmaFontSizeToSp(14f),
            lineHeight = figmaHeightToDp(20f).sp,
            style = textStyle,
            color = MaterialTheme.colorScheme.onTertiary
        )
    }
}




