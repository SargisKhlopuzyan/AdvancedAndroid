package com.sargis.khlopuzyan.advancedandroid.ui

sealed class MainScreens(val route: String) {
    object MainScreen: MainScreens("main_screen")
    object EffectHandlers: MainScreens("effect_handlers")
    object Continuation: MainScreens("continuation")
    object ThreadHandlerLooperThreadPool: MainScreens("thread_handler_looper_thread_pool")
    object CustomViewModel: MainScreens("custom_view_model")
    object CustomViewModelWithSavedStateHandler: MainScreens("custom_view_model_with_saved_state_handler")
    object ForegroundService: MainScreens("foreground_service")
    object WorkManager: MainScreens("work_manager")
}