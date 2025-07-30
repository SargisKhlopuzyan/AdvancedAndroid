package com.sargis.khlopuzyan.advancedandroid

/** Thread :
 *
 * Thread → A light-weight processes. Unit of execution. Perform background long running task.
 * */

/** Looper :
 *
 * Looper → It is a worker that keeps the thread alive and loops through messages in MessageQueue and sends messages to Handler to process callbacks and messages.
 * Main looper is the one which makes main thread alive in Android.
 * Same way, If we want to have own looper for a worker thread,
 * Then we can definitely create it by doing Looper.prepare() and Looper.loop()
 *
 *
 * Looper class does two things:
 *
 * It converts an ordinary thread (which is destroyed when its run method is finished) to a thread that can stay alive as long as the Android app is alive.
 * It has a queue of tasks to execute.
 * */

/**
 * Handler :
 *
 * We can not directly add a task to the queue of a Looper.
 * Instead, we should use an instance of a Handler to do the trick.
 * In other words, we use a Handler to add a task to the queue of a Looper.
 * */

/** Handler Thread :
 *
 * Handler Thread → is the workaround on Thread and Looper. HandlerThread is a thread which has a looper.
 * Looper can then be used to create Handler. Like other threads, start() must be called to start HandlerThread.
 * */