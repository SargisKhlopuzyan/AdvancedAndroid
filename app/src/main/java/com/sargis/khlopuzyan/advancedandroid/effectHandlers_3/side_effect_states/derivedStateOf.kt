package com.sargis.khlopuzyan.advancedandroid.effectHandlers_3.side_effect_states

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun DerivedStateOfMain() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {


    }
}

@Composable
private fun ConditionalRenderingExample() {
    var isLoggedIn by remember {
        mutableStateOf(false)
    }

    val buttonText by remember {
        derivedStateOf {
            if (isLoggedIn) "Logout" else "Login"
        }
    }

    Button(
        onClick = {
            isLoggedIn = !isLoggedIn
        }
    ) {
        Text(text = buttonText)
    }
}

@Composable
private fun CombinedStateExample() {

    var count by remember { mutableIntStateOf(0) }
    var threshold by remember { mutableIntStateOf(10) }

    val isThresholdReached by remember {
        derivedStateOf {
            count >= threshold
        }
    }

    Text(
        text = if (isThresholdReached) "Threshold Reached" else "Threshold Not Reached"
    )
}

@Composable
private fun ComplexCalculationExample() {

    var radius by remember { mutableFloatStateOf(5f) }
    var diameter by remember { mutableFloatStateOf(0f) }

    val circumference by remember {
        derivedStateOf {
            2 * radius * 3.14f
        }
    }

    Text(text = "Circumference: $circumference")
}

@Composable
private fun DynamicStylingExample(isDarkTheme: Boolean) {

    val backgroundColor by remember {
        derivedStateOf {
            if (isDarkTheme) Color.Black else Color.White
        }
    }

    Surface(color = backgroundColor) {
        Text(
            text = "Dynamic Styling Example",
            color = if (isDarkTheme) Color.White else Color.Black
        )
    }
}