package com.sargis.khlopuzyan.advancedandroid.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Dispatchers.Main - Main thread
 *
 * Dispatchers.IO - Networking, Writing to Database, reading or writing files
 *
 * Dispatchers.Default - complex or long-running calculations (eg sorting list of 10.000 elements)
 *
 * Dispatchers.Unconfined - it is not confined to any specific thread. It executes the initial
 *                          continuation of a coroutine in the current call-frame and lets the
 *                          coroutine resume in whatever thread that is used by the corresponding
 *                          suspending function, without mandating any specific threading policy
 * */
fun main() {

    GlobalScope.launch(Dispatchers.IO) {

    }
}