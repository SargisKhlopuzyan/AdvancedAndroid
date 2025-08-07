package com.sargis.khlopuzyan.advancedandroid.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sargis.khlopuzyan.advancedandroid.viewmodel.CustomViewModelCompose

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MainScreens.MainScreen.route
    ) {
        composable(route = MainScreens.MainScreen.route) {
            MainScreen(navController)
        }
        composable(route = MainScreens.ThreadHandlerLooperThreadPool.route) {

        }
        composable(route = MainScreens.Continuation.route) {

        }
        composable(route = MainScreens.EffectHandler.route) {

        }
        composable(route = MainScreens.CustomViewModel.route) {
            CustomViewModelCompose()
        }
    }
}