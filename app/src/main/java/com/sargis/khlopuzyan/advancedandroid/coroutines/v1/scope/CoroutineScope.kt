package com.sargis.khlopuzyan.advancedandroid.coroutines.v1.scope

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * LOG_TAG_main_1
 * LOG_TAG_coroutineScope_1
 * LOG_TAG_main_2
 * */
//private fun main() = runBlocking {
//    println("LOG_TAG_main_1")
//    coroutineScope {
//        delay(1000)
//        println("LOG_TAG_coroutineScope_1")
//    }
//    println("LOG_TAG_main_2")
//}

/**
 * LOG_TAG_main_1
 * LOG_TAG_coroutineScope_launch_1
 * LOG_TAG_coroutineScope_launch_2
 * LOG_TAG_main_2
 * */
//private fun main() = runBlocking {
//    println("LOG_TAG_main_1")
//    coroutineScope {
//        launch {
//            delay(1000)
//            println("LOG_TAG_coroutineScope_launch_1")
//        }
//
//        launch {
//            delay(2000)
//            println("LOG_TAG_coroutineScope_launch_2")
//        }
//    }
//    println("LOG_TAG_main_2")
//}

/**
 * LOG_TAG_main_1
 * LOG_TAG_coroutineScope_launch_1
 * Exception in thread "main" java.lang.Exception: LOG_TAG_coroutineScope_launch_1
 * */
private fun main() = runBlocking {
    println("LOG_TAG_main_1")
    coroutineScope {
        launch {
            delay(1000)
            println("LOG_TAG_coroutineScope_launch_1")
            throw Exception("LOG_TAG_coroutineScope_launch_1")
        }

        launch {
            delay(2000)
            println("LOG_TAG_coroutineScope_launch_2")
        }
    }
    println("LOG_TAG_main_2")
}