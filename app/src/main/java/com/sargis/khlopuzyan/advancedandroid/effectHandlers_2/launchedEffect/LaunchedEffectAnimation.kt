package com.sargis.khlopuzyan.advancedandroid.effectHandlers_2.launchedEffect

import androidx.compose.animation.core.Animatable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember

@Composable
fun LaunchedEffectAnimation(
    counter: Int
) {
    val animation = remember {
        Animatable(0f)
    }

    LaunchedEffect(counter) {
        animation.animateTo(counter.toFloat())
    }
}