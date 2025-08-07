package com.sargis.khlopuzyan.advancedandroid.ui

sealed class MainScreens(val route: String) {
    object MainScreen: MainScreens("main_screen")
    object EffectHandler: MainScreens("effect_handler")
    object Continuation: MainScreens("continuation")
    object ThreadHandlerLooperThreadPool: MainScreens("thread_handler_looper_thread_pool")
    object CustomViewModel: MainScreens("custom_view_model")
}