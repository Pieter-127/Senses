package com.pieterv.senses.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pieterv.senses.presentation.MainScreen
import com.pieterv.senses.presentation.MainViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val mainViewModel: MainViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
        composable(
            route = Screen.LoginScreen.route,
        ) {
            MainScreen(
                navController = navController,
                viewModel = mainViewModel,
            )
        }
    }
}
