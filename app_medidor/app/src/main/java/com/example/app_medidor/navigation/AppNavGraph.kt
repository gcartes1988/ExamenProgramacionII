package com.example.app_medidor.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app_medidor.ui.screens.FormScreen
import com.example.app_medidor.ui.screens.MainScreen
import com.example.app_medidor.viewmodel.ReadingViewModel

@Composable
fun AppNavGraph(readingViewModel: ReadingViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(readingViewModel = readingViewModel, navController = navController)
        }
        composable("form") {
            FormScreen(readingViewModel = readingViewModel, navController = navController)
        }
    }
}
