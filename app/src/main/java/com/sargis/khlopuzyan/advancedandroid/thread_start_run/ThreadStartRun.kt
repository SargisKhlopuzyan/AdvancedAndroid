package com.sargis.khlopuzyan.advancedandroid.thread_start_run

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * LOG_TAG_run_i: 0, name: MyThread
 * LOG_TAG_run_i: 0, name: DefaultDispatcher-worker-3
 * LOG_TAG_run_i: 0, name: DefaultDispatcher-worker-1
 * ...
 * */
fun main() = runBlocking {
    val myThread = MyThread()
    launch(Dispatchers.Default) {
        launch {
            myThread.start()
        }
        launch {
            delay(300)
            myThread.run()
        }

        launch {
            delay(600)
            myThread.run()
        }
    }
    Unit
}

class MyThread: Thread("MyThread") {
    override fun run() {
        for (i in 0..50) {
            sleep(1000)
            println("LOG_TAG_run_i: $i, name: ${Thread.currentThread().name}")
        }
    }
}