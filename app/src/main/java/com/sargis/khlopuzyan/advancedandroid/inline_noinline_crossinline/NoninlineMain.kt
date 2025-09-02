package com.sargis.khlopuzyan.advancedandroid.inline_noinline_crossinline

fun main() {

}

inline fun higherOrderFunction(
    lambda1: () -> Unit,
    noinline doNotInlineLambda: () -> Unit,
    lambda2: () -> Unit,
) {
    doSomething()

    lambda1()
    doNotInlineLambda() //won't be inlined.
    lambda2()

    doAnotherThing()

}

fun doSomething() {}

fun doAnotherThing() {}