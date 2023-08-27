package com.example.reversiapp.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.reversiapp.ui.main.MainScreen
import com.example.reversiapp.ui.settings.SettingsScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController, viewModel = viewModel())
        }
        composable(route = Screen.SettingsScreen.route) {
            SettingsScreen(navController, viewModel = viewModel())
        }
    }
}
