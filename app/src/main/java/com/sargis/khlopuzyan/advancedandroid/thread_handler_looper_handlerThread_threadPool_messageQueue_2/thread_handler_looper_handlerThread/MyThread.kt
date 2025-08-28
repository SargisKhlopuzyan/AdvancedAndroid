package com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_threadPool_messageQueue_2.thread_handler_looper_handlerThread

//TODO-URL: https://mfallahpour.medium.com/android-loopers-and-handlers-demystified-481eef1f3984

//fun main() {
//    val myThread: MyThread = MyThread()
//    myThread.start()
//
//}

class MyThread: Thread() {

    override fun run() {
        someLongRunningOperation()
    }

    private fun someLongRunningOperation() {
        sleep(5000)
    }
}