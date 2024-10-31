package com.example.mydoctor


import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mydoctor.ui.screens.AddDataScreen
import com.example.mydoctor.ui.screens.MainScreen
import com.example.mydoctor.ui.theme.MyDoctorTheme
import com.example.mydoctor.ui.util.ScreenMetrics
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScreenMetrics.initialize()
            MyDoctorTheme{
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = "main_screen",
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            composable("main_screen") {
                                MainScreen(navController = navController)
                            }
                            composable("add_data_screen") {
                                AddDataScreen(navController = navController)
                            }
                        }
                    }
                }
            }
        }
    }
}






