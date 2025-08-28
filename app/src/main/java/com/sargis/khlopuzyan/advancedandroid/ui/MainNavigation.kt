package com.sargis.khlopuzyan.advancedandroid.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sargis.khlopuzyan.advancedandroid.effectHandlers_2.EffectHandlers
import com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_message_messageQueue_threadPool_2.HandlerLooperThreadHandlerThreadThreadPoolMessageQueue
import com.sargis.khlopuzyan.advancedandroid.service.ServiceScreen
import com.sargis.khlopuzyan.advancedandroid.viewmodel.MyCompose
import com.sargis.khlopuzyan.advancedandroid.viewmodel.savedStateHandler.MySavedStateHandlerCompose
import com.sargis.khlopuzyan.advancedandroid.workManager.WorkManagerScreen

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
            HandlerLooperThreadHandlerThreadThreadPoolMessageQueue()
        }
        composable(route = MainScreens.Continuation.route) {

        }
        composable(route = MainScreens.EffectHandlers.route) {
            EffectHandlers()
        }
        composable(route = MainScreens.CustomViewModel.route) {
            MyCompose()
        }
        composable(route = MainScreens.CustomViewModelWithSavedStateHandler.route) {
            MySavedStateHandlerCompose()
        }
        composable(route = MainScreens.ForegroundService.route) {
            ServiceScreen()
        }
        composable(route = MainScreens.WorkManager.route) {
            WorkManagerScreen()
        }
    }
}