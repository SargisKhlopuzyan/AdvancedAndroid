package com.sargis.khlopuzyan.advancedandroid.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import kotlin.random.Random

//TODO-URL: https://www.youtube.com/watch?v=9sqvBydNJSg&ab_channel=PhilippLackner
//TODO-URL: https://www.youtube.com/watch?v=nNv1a0nmOfk&ab_channel=SagarMalhotra
class MyViewModel(
    defaultColor: Color
) : ViewModel() {

    var backgroundColor by mutableStateOf(defaultColor)
        private set

    fun changeBackgroundColor() {
        backgroundColor = generateRandomColor()
    }
}

fun generateRandomColor(): Color {
    val red = Random.nextInt(256) // Generates a random integer between 0 and 255 for Red
    val green = Random.nextInt(256) // Generates a random integer between 0 and 255 for Green
    val blue = Random.nextInt(256) // Generates a random integer between 0 and 255 for Blue
    return Color(red, green, blue)
}