package com.sargis.khlopuzyan.advancedandroid.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
/**
 * Calls the specified suspending block with a given coroutine context,
 * suspends until it completes, and returns the result.
 * */


/**
 * LOG_TAG_main_1
 * LOG_TAG_withContext
 * LOG_TAG_main_2
 * */
//fun main() = runBlocking {
//    println("LOG_TAG_main_1")
//    withContext(Dispatchers.IO) {
//        delay(1000)
//        println("LOG_TAG_withContext")
//    }
//    println("LOG_TAG_main_2")
//}

/**
 * LOG_TAG_main_1
 * LOG_TAG_withContext_launch
 * LOG_TAG_main_2
 * */
//fun main() = runBlocking {
//    println("LOG_TAG_main_1")
//    withContext(Dispatchers.IO) {
//        launch {
//            delay(1000)
//            println("LOG_TAG_withContext_launch")
//        }
//    }
//    println("LOG_TAG_main_2")
//}

/**
 * LOG_TAG_main_1
 * LOG_TAG_main_2
 * LOG_TAG_launch
 * */
//fun main() = runBlocking {
//    println("LOG_TAG_main_1")
//    launch(Dispatchers.IO) {
//        delay(1000)
//        println("LOG_TAG_launch")
//    }
//    println("LOG_TAG_main_2")
//}

/**
 * LOG_TAG_main_1
 * LOG_TAG_launch.join()
 * LOG_TAG_main_2
 * */
fun main() = runBlocking {
    println("LOG_TAG_main_1")
    launch(Dispatchers.IO) {
        delay(1000)
        println("LOG_TAG_launch.join()")
    }.join()
    println("LOG_TAG_main_2")
}