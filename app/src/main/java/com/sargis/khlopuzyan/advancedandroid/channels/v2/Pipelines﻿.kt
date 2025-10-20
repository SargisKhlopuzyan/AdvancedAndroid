package com.sargis.khlopuzyan.advancedandroid.channels.v2

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

private fun main() = runBlocking {
    var cur = numbersFrom(2)
    repeat(10) {
        val prime = cur.receive()
        println(prime)
        cur = filter(cur, prime)
    }
    Dispatchers.Default
    coroutineContext.cancelChildren() // cancel all children to let main finish
}

private fun CoroutineScope.numbersFrom(start: Int) = produce<Int> {
    var x = start
    while (true) send(x++) // infinite stream of integers from start
}

private fun CoroutineScope.filter(numbers: ReceiveChannel<Int>, prime: Int) = produce<Int> {
    for (x in numbers) if (x % prime != 0) send(x)
}