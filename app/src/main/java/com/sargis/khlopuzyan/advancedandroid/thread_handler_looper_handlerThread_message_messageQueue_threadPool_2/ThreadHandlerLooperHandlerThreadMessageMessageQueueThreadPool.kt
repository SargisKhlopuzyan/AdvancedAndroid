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
import com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_message_messageQueue_threadPool_2.thread_handler_looper_handlerThread.handlerWorkerThread
import com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_message_messageQueue_threadPool_2.thread_handler_looper_handlerThread.looperWorkerThread
import com.sargis.khlopuzyan.advancedandroid.thread_handler_looper_handlerThread_message_messageQueue_threadPool_2.thread_handler_looper_handlerThread.myWorkerThread

@Composable
fun HandlerLooperThreadHandlerThreadThreadPoolMessageQueue() {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(onClick = {
                looperWorkerThread()
            }) {
                Text(text = "looperWorkerThread()")
            }

            Button(onClick = {
                myWorkerThread()
            }) {
                Text(text = "myWorkerThread()")
            }

            //////////////////////////////////////

            Button(onClick = {
                handlerWorkerThread()
            }) {
                Text(text = "handlerWorkerThread()")
            }

            /////////////////////////

            Button(onClick = {
                customHandlerMain()
            }) {
                Text(text = "customHandlerMain()")
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