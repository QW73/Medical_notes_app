package com.example.mydoctor.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mydoctor.ui.screens.addData.AddDataButton
import com.example.mydoctor.ui.screens.addData.AddDataHeader
import com.example.mydoctor.ui.screens.addData.DataFields
import com.example.mydoctor.ui.util.ScreenMetrics.figmaHeightToDp
import com.example.mydoctor.ui.util.ScreenMetrics.figmaWidthToDp
import com.example.mydoctor.ui.util.blur.Blur


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AddDataScreen(modifier: Modifier = Modifier, navController: NavController) {

    val addDataViewModel: AddDataViewModel = hiltViewModel()

    Blur(2)

    val errorMessage = addDataViewModel.errorMessage
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(errorMessage) {
        errorMessage?.let {
            snackbarHostState.showSnackbar(it)
            addDataViewModel.errorMessage = null
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = figmaWidthToDp(16f).dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(figmaHeightToDp(24f).dp, Alignment.Top),
    ) {

        AddDataHeader() {
            navController.navigate("main_screen")
        }

        DataFields(
            modifier = Modifier.weight(1f), addDataViewModel
        )

        AddDataButton(modifier, addDataViewModel)

        SnackbarHost(
            hostState = snackbarHostState, modifier = Modifier.align(Alignment.CenterHorizontally)
        )

    }
}
