package com.sargis.khlopuzyan.advancedandroid.effectHandlers_2._sideEffect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect

@Composable
fun SideEffectDemo(onComposeCounter: Int) {
    SideEffect {
        println("Called after every successful recomposition")
    }
}