package com.sargis.khlopuzyan.advancedandroid.coroutines.scope

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

/**
 * LOG_TAG_main_1
 * LOG_TAG_supervisorScope_1
 * LOG_TAG_main_2
 *
 * Process finished with exit code 0
 * */
//private fun main() = runBlocking {
//    println("LOG_TAG_main_1")
//    supervisorScope {
//        delay(1000)
//        println("LOG_TAG_supervisorScope_1")
//    }
//    println("LOG_TAG_main_2")
//}

/**
 * LOG_TAG_main_1
 * LOG_TAG_supervisorScope_1
 * Exception in thread "main" java.lang.Exception: LOG_TAG_supervisorScope_1
 *
 * Process finished with exit code 1
 * */
//private fun main() = runBlocking {
//    println("LOG_TAG_main_1")
//    supervisorScope {
//        delay(1000)
//        println("LOG_TAG_supervisorScope_1")
//        throw Exception("LOG_TAG_supervisorScope_1")
//    }
//    println("LOG_TAG_main_2")
//}

/**
 * LOG_TAG_main_1
 * LOG_TAG_supervisorScope_1
 * Exception in thread "main" java.lang.Exception: LOG_TAG_supervisorScope_1 ...
 * LOG_TAG_main_2
 *
 * Process finished with exit code 0
 * */
//private fun main() = runBlocking {
//    println("LOG_TAG_main_1")
//    supervisorScope {
//        delay(1000)
//        println("LOG_TAG_supervisorScope_1")
//        launch {
//            throw Exception("LOG_TAG_supervisorScope_1")
//        }
//    }
//    println("LOG_TAG_main_2")
//}

/**
 * LOG_TAG_main_1
 * LOG_TAG_supervisorScope_launch_1
 * Exception in thread "main" java.lang.Exception: LOG_TAG_supervisorScope_1 ...
 * LOG_TAG_supervisorScope_launch_2
 * LOG_TAG_main_2
 *
 * Process finished with exit code 0
 * */
private fun main() = runBlocking {
    println("LOG_TAG_main_1")
    supervisorScope {
        launch {
            delay(1000)
            println("LOG_TAG_supervisorScope_launch_1")
            throw Exception("LOG_TAG_supervisorScope_1")
        }

        launch {
            delay(2000)
            println("LOG_TAG_supervisorScope_launch_2")
        }
    }
    println("LOG_TAG_main_2")
}