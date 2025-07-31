package com.sargis.khlopuzyan.advancedandroid.effectHandlers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext

/**
 * 4. DisposableEffect:
 * A compose function that allows you to pass keys and a block of code (similar to the LaunchedEffect)
 * but with extra functionality to write a cleanup block of code.
 * */
@Composable
fun DisposableEffectComposable() {
    val context = LocalContext.current
    DisposableEffect(context) {
        // register()

        onDispose {
            // unregister()
        }
    }
}