package com.sargis.khlopuzyan.advancedandroid

import android.os.Bundle
import android.util.Log
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
//        finish()
    }

    override fun onStart() {
//        finish()
        Log.e("LOG_TAG", "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.e("LOG_TAG", "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.e("LOG_TAG", "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.e("LOG_TAG", "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.e("LOG_TAG", "onDestroy")
        super.onDestroy()
    }
}