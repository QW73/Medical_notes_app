package com.example.mydoctor.ui.screens.main.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mydoctor.ui.util.ScreenMetrics.figmaHeightToDp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaWidthToDp

@Composable
fun MainHeader(modifier: Modifier = Modifier, navController: NavController) {

    val headerHeight = figmaHeightToDp(117f).dp

    val headerComponentsWidth = figmaWidthToDp(343f)
    val logoHeight = figmaHeightToDp(45f)
    val headerCaption = figmaHeightToDp(40f)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(headerHeight),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top

    ) {
        Logo(headerComponentsWidth, logoHeight)
        Spacer(modifier = Modifier.height(figmaHeightToDp(16f).dp))
        HeaderCaption(headerComponentsWidth, headerCaption)
        {
            navController.navigate("add_data_screen")
        }

    }
}