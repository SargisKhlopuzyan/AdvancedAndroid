package com.sargis.khlopuzyan.advancedandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sargis.khlopuzyan.advancedandroid.ui.MainNavigation
import com.sargis.khlopuzyan.advancedandroid.ui.theme.AdvancedAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdvancedAndroidTheme {
                MainNavigation()
            }
        }
    }
}