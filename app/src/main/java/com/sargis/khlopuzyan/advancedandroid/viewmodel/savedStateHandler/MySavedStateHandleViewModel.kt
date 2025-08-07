package com.sargis.khlopuzyan.advancedandroid.viewmodel.savedStateHandler

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sargis.khlopuzyan.advancedandroid.viewmodel.generateRandomColor
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class MySavedStateHandleViewModel(
    defaultColor: Color,
    val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val backgroundColor =
        savedStateHandle.getStateFlow("BackgroundColor", defaultColor.toArgb()).map {
            Color(it)
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), defaultColor)

    fun changeBackgroundColor() {
        savedStateHandle["BackgroundColor"] = generateRandomColor().toArgb()
    }
}