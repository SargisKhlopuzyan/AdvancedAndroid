package com.sargis.khlopuzyan.advancedandroid.compositionLocal

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun main() {
}

// 1. Define a spacing data class
data class Spacing(
    val small: Dp = 4.dp,
    val medium: Dp = 8.dp,
    val large: Dp = 16.dp,
)

// 2. Create a CompositionLocal
val LocalSpacing = compositionLocalOf { Spacing() }

// 3. Provide custom spacing for a specific screen
@Composable
fun SpecialScreen() {
    Column {
        CustomCard("Hello", "This card uses custom spacing")
        CompositionLocalProvider(LocalSpacing provides Spacing(8.dp, 16.dp, 24.dp)) {
            CustomCard("Hello", "This card uses custom spacing")
        }
    }
}

// 4. Consume it
@Composable
fun CustomCard(title: String, content: String) {
    val spacing = LocalSpacing.current
    Card(modifier = Modifier.padding(spacing.medium)) {
        Column(modifier = Modifier.padding(spacing.medium)) {
            Text(title, modifier = Modifier.padding(bottom = spacing.small))
            Text(content)
        }
    }
}

@Composable
fun ExampleWithBuiltInLocals() {
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Button(onClick = {
        // Using the retrieved values
        Toast.makeText(context, "Clicked!", Toast.LENGTH_SHORT).show()
        keyboardController?.hide()  // Note: keyboard controller might be null
        focusManager.clearFocus()
    }) {
        Text("Click Me")
    }
}

@Preview(showBackground = true)
@Composable
fun SpecialScreenPreview() {
    SpecialScreen()
}