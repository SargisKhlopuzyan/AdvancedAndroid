package com.sargis.khlopuzyan.advancedandroid.continuation

import kotlinx.coroutines.delay
import kotlinx.coroutines.internal.resumeCancellableWith
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

//TODO-DO-AGAIN
//TODO-URL : https://stackoverflow.com/questions/73679497/how-does-continuation-work-in-kotlin-coroutine

private fun main() {

}
/**

// code 1
suspend fun getEmployee() {
    println("Start main()")
    var inc = 0
    val id = getID()
    inc++
    println("End main() $inc $id")
}

private suspend fun getID(): Int {
    delay(1000)
    return 1
}

/////////////////////////////////////////////////////////////////

suspend fun getStudent(rollno: Int): Student? {
    TODO()
}

suspend fun setStudentRollno(name: String): Unit {

}

suspend fun showData(): Unit {

}

// under hood
//fun getStudent(rollno: Int, continuation: Continuation<*>): Any? {
fun getStudent(rollno: Int, continuation: Continuation<Student>): Any? {
//    continuation.resume()
//    continuation.resumeWith()
//    continuation.resumeWithException()
//    continuation.resumeCancellableWith()
    TODO()
}

//fun setStudentRollno(name: String, continuation: Continuation<*>): Any {
fun setStudentRollno(name: String, continuation: Continuation<String>): Any {
    TODO()
}

//fun showData(continuation: Continuation<*>): Any {
fun showData(continuation: Continuation<Unit>): Any {
//    suspendCancellableCoroutine<Int> {
//        10
//    }
    TODO()
}

class Student
*/
