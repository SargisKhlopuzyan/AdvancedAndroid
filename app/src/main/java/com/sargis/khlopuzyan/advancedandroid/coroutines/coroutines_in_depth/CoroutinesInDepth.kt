package com.sargis.khlopuzyan.advancedandroid.coroutines.coroutines_in_depth

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.coroutineContext
import kotlin.system.measureTimeMillis

//private fun main() = runBlocking {
//    val timeMillis = measureTimeMillis {
//        println("Fetching dashboard data...")
//        val userDeferred = async { fetchUserData() }
//        val notificationsDeferred = async { fetchNotificationCount() }
//        // Wait for both results to complete
//        val userData = userDeferred.await()
//        val notifications = notificationsDeferred.await()
//        println("Dashboard Data: $userData, Notifications: $notifications")
//    }
//
//    println("timeMillis: $timeMillis")
//}


private fun main() = runBlocking {
    val timeMillis = measureTimeMillis {
        val dispatcher = coroutineContext[CoroutineDispatcher]

        println("runBlocking, thread: ${Thread.currentThread()}")
        println("runBlocking, dispatcher: $dispatcher")
        println("Fetching dashboard data...")

        val userDeferred = launch { fetchUserData() }
        val notificationsDeferred = launch { fetchNotificationCount() }
        // Wait for both results to complete
        listOf(userDeferred, notificationsDeferred).joinAll()
    }

    println("timeMillis: $timeMillis")
}

suspend fun fetchUserData(): String {
    delay(1000) // Simulate API call
    val dispatcher = coroutineContext[CoroutineDispatcher]
    println("fetchUserData, thread: ${Thread.currentThread()}")
    println("fetchUserData, dispatcher: $dispatcher")
    return "User: Jane Doe"
}

suspend fun fetchNotificationCount(): Int {
    delay(500) // Simulate API call
    val dispatcher = coroutineContext[CoroutineDispatcher]
    println("fetchNotificationCount, thread: ${Thread.currentThread()}")
    println("fetchNotificationCount, dispatcher: $dispatcher")
    return 5
}