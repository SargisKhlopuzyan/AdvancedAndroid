package com.sargis.khlopuzyan.advancedandroid.effectHandlers_4

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext

@Composable
fun DisposableEffectDemo() {
    val context = LocalContext.current
    DisposableEffect(key1 = true) {
//        register() //Registering a callback is a side-effect and should be done one time
        onDispose {
//            unregister() //Any Callback needs to be unregistered to prevent memory leaks
        }
    }
}