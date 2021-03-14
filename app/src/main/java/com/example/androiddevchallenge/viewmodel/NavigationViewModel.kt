package com.example.androiddevchallenge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.HOME_SCREEN
import com.example.androiddevchallenge.WELCOME_SCREEN

class NavigationViewModel(
    private val navController: NavHostController
    ) : ViewModel() {

    private var currentScreen = WELCOME_SCREEN
    val CURRENT_SCREEN = currentScreen

    fun goto(screen: String, clearBackStack :Boolean= false) {
        currentScreen = screen
        navController.navigate(screen) {
            if (clearBackStack) {
                popUpTo = navController.graph.startDestination
                launchSingleTop = true
            }
        }
    }

    val startDestination: String = WELCOME_SCREEN

}