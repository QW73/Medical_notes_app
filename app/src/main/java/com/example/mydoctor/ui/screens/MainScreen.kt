package com.example.mydoctor.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mydoctor.ui.screens.main.body.Body
import com.example.mydoctor.ui.screens.main.header.MainHeader
import com.example.mydoctor.ui.util.blur.Blur


@Composable
fun MainScreen(modifier: Modifier = Modifier, navController: NavController) {

    val mainViewModel: MainViewModel = hiltViewModel()

    Blur(1)

    Column(
        modifier = modifier
            .fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        MainHeader(modifier, navController)
        Body(modifier,mainViewModel)
    }
}

