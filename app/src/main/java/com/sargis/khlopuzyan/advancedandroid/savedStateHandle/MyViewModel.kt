package com.sargis.khlopuzyan.advancedandroid.savedStateHandle

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MyViewModel(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    var name = savedStateHandle.get<String>("name") ?: ""
    var email = savedStateHandle.get<String>("email") ?: ""

    fun onNameChanged(newName: String) {
        savedStateHandle["name"] = newName
    }
}