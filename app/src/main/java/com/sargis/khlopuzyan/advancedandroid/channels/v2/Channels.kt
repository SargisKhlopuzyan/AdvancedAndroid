package com.sargis.khlopuzyan.advancedandroid.channels.v2

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {

    val channel = Channel<Int>()

    launch {
        for (x in 1..6) {
            channel.send(x * x)
        }
        channel.close() // we're done sending
    }

//    repeat(5) {
//        println(channel.receive())
//    }

    for (c in channel) {
        println("$c")
    }

    println("Done!")
}