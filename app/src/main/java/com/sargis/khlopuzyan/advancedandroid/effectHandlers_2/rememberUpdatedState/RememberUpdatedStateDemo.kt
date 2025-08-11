package com.sargis.khlopuzyan.advancedandroid.effectHandlers_2.rememberUpdatedState

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

@Composable
fun RememberUpdatedStateDemo(
    onTimeout: () -> Unit,
) {
    // TODO - in case this composable recompose many times, with launched effect  it will take only
    //  first onTimeout and will call only first onTimeout instance, with rememberUpdatedState it will
    //  always update to last one

//    LaunchedEffect(true) {
//        delay(3000)
//        onTimeout()
//    }

    val updatedOnTimeout by rememberUpdatedState(newValue = onTimeout)

    LaunchedEffect(true) {
        delay(3000)
//        onTimeout()
        updatedOnTimeout()
    }
}