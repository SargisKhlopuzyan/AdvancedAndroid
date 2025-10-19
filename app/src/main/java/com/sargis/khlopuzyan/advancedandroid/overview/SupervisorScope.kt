package com.sargis.khlopuzyan.advancedandroid.overview

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

private fun main() = runBlocking {
    launch {
        launch {
            println("l-1")
        }

        launch {
            delay(600)
            println("l-2")
        }

        val handler = CoroutineExceptionHandler {
            _, t->
            println("In CoroutineExceptionHandler")
        }
        try {
            async(handler) {
                delay(200)
                throw RuntimeException("RuntimeException")
            }.await()
        } catch (e: Exception) {
            println("In try catch")
        }
    }

    launch {
        delay(100)
        println("l-4")
    }

    launch {
        delay(800)
        println("l-5")
    }

    delay(1000)
}

private fun main1() = runBlocking {

    val context = Job() +
            Dispatchers.IO +
            CoroutineName("Any") +
            CoroutineExceptionHandler { _, throwable ->
                println("CoroutineExceptionHandler ***** ${throwable.message}")
            }

    val scope = CoroutineScope(context)

    scope.launch {
        launch {
            launch {
                println("launch-1")
            }

            launch {
                launch {
                    delay(50)
                    println("launch-2-1")
                }

                launch {
                    delay(100)
                    println("launch-2-2")
                }

                launch {
                    delay(300)
                    throw RuntimeException("Exception-in-*launch-2")
                }

                launch {
                    delay(600)
                    println("launch-2-3")
                }
            }

            launch {
                delay(800)
                println("launch-3")
            }
        }

        launch {
            delay(1000)
            println("launch-4")
        }

//        launch {
//            delay(200)
//            throw RuntimeException("Exception-in-*launch-2")
//        }
    }

    launch {
        delay(2000)
        println("launch-5")
    }

    delay(3000)
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

// TODO-OK
private fun main2() = runBlocking {
    val handler = CoroutineExceptionHandler { _, throwable ->
        println("CoroutineExceptionHandler ***** ${throwable.message}")
    }

    supervisorScope {
        launch(handler) {

            launch {
                println("launch-1")
            }

            launch {
                launch {
                    delay(50)
                    println("launch-2-1")
                }

                launch {
                    delay(100)
                    println("launch-2-2")
                }

                launch {
                    delay(300)
                    throw RuntimeException("Exception-in-*launch-2")
                }

                launch {
                    delay(600)
                    println("launch-2-3")
                }
            }

            launch {
                delay(800)
                println("launch-3")
            }
        }

        launch {
            delay(1000)
            println("launch-4")
        }

//        launch {
//            delay(200)
//            throw RuntimeException("Exception-in-*launch-2")
//        }
    }

    launch {
        delay(2000)
        println("launch-5")
    }

    delay(3000)
}