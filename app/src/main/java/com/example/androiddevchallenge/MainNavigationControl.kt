package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androiddevchallenge.screens.MainScreen
import com.example.androiddevchallenge.screens.LoginScreen
import com.example.androiddevchallenge.screens.WelcomeScreen
import com.example.androiddevchallenge.viewmodel.NavigationViewModel
import com.example.androiddevchallenge.viewmodel.SoothViewModel

@Composable
fun MainNavigationControl(navController: NavHostController){
    val navigationViewModel= NavigationViewModel(navController)
    val soothViewModel = SoothViewModel()
    NavHost(navController, startDestination = navigationViewModel.startDestination) {
        composable(WELCOME_SCREEN) {
            WelcomeScreen(navigationViewModel)
        }
        composable(LOGIN_SCREEN) {
            LoginScreen(navigationViewModel)
        }
        composable(HOME_SCREEN){
            MainScreen(navigationViewModel, soothViewModel)
        }
    }
}