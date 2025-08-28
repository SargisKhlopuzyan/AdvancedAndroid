package com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_message_messageQueue_threadPool_2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_message_messageQueue_threadPool_2.messageQueue.messageAndMessageQueue
import com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_message_messageQueue_threadPool_2.threadPool.threadPool
import com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_message_messageQueue_threadPool_2.thread_handler_looper_handlerThread.HandlerWorkerThread
import com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_message_messageQueue_threadPool_2.thread_handler_looper_handlerThread.LooperWorkerThread

val looperWorkerThread = LooperWorkerThread()
val handlerWorkerThread = HandlerWorkerThread()

@Composable
fun HandlerLooperThreadHandlerThreadThreadPoolMessageQueue() {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(onClick = {
                looperWorkerThread.execute {
                    // Do something
                    println("LOG_TAG_execute_1 ${Thread.currentThread().name}")
                }
                looperWorkerThread.execute {
                    // Do something else
                    println("LOG_TAG_execute_2 ${Thread.currentThread().name}")
                }
            }) {
                Text(text = "LooperWorkerThread")
            }

            Button(onClick = {
                looperWorkerThread.quit()
            }) {
                Text(text = "Quit LooperWorkerThread")
            }

            //////////////////////////////////////

            Button(onClick = {
                handlerWorkerThread.execute {
                    // Do something
                    println("LOG_TAG_handlerWorkerThread.execute_1 ${Thread.currentThread().name}")
                }
                handlerWorkerThread.execute {
                    // Do something else
                    println("LOG_TAG_handlerWorkerThread.execute_2 ${Thread.currentThread().name}")
                }
            }) {
                Text(text = "HandlerWorkerThread")
            }

            /////////////////////////

            Button(onClick = {
                customHandlerMain()
            }) {
                Text(text = "customHandlerMain")
            }

            Button(onClick = {
                customHandlerSendMessage()
            }) {
                Text(text = "customHandlerSendMessage()")
            }

            ////////////////////////////

            Button(onClick = {
                messageAndMessageQueue()
            }) {
                Text(text = "messageAndMessageQueue()")
            }

            /////////////////////////////

            Button(onClick = {
                threadPool()
            }) {
                Text(text = "threadPool()")
            }
        }
    }
}