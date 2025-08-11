package com.sargis.khlopuzyan.advancedandroid.effectHandlers_2.launchedEffect

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class LaunchedEffectViewModel : ViewModel() {

    private val _sharedFlow = MutableSharedFlow<ScreenEvents>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    sealed interface ScreenEvents {
        data class ShowSnackbar(val message: String): ScreenEvents
        data class Navigate(val route: String): ScreenEvents
    }
}