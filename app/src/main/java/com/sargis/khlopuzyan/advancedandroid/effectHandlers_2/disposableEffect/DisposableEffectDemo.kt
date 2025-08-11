package com.sargis.khlopuzyan.advancedandroid.effectHandlers_2.disposableEffect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner

@Composable
fun DisposableEffectDemo() {
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(key1 = lifecycleOwner) {

        val observer = LifecycleEventObserver { source: LifecycleOwner, event: Lifecycle.Event ->
            if (event == Lifecycle.Event.ON_PAUSE) {
                println("On pause called")
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}