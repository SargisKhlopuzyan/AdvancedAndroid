package com.sargis.khlopuzyan.advancedandroid.effectHandlers_4

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun DerivedStateOfDemo() {
    val counter by remember {
        mutableIntStateOf(0)
    }

    val text by remember {
        derivedStateOf {
            if (counter > 10) {
                mutableStateOf("High $counter")
            } else {
                mutableStateOf("Low")
            }
        }
    }
}