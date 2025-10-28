package com.sargis.khlopuzyan.advancedandroid.coroutines.v1.scope

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

//TODO-URL: https://www.youtube.com/watch?v=5AfIs6xydJ4&ab_channel=SimplifiedCoding
/**
 * coroutineScope cancels everything if one child coroutine fails,
 * while supervisorScope keeps going even if a child fails.
 * */
private fun main() = runBlocking {

    try {
            supervisorScope {
//        coroutineScope {
            val chatRooms = async {
                getChatRooms()
            }

            val users = async {
                getUsers()
            }

            val config = async {
                getConfig()
            }

            println("*** users: ${users.await()}")

            try {
                println("*** chatRooms: ${chatRooms.await()}")
            } catch (e: Exception) {
                e.printStackTrace()
            }

            println("*** config: ${config.await()}")
        }
    } catch (e: Exception) {
        println("*** Inside Parent Catch Block")
    }
}

private suspend fun getChatRooms(): List<ChatRoom> {
    delay(1500)
    throw IllegalStateException("*** Chat rooms not ready")
}

private suspend fun getUsers(): List<User> {
    delay(1000)
//    delay(2000)
    return listOf(User(1, "User1"), User(2, "User2"))
}

private suspend fun getConfig(): AppConfig {
    delay(3000)
    return AppConfig("Config")
}

data class User(val id: Int, val name: String)
data class ChatRoom(val id: Int, val name: String)
data class AppConfig(val config: String)