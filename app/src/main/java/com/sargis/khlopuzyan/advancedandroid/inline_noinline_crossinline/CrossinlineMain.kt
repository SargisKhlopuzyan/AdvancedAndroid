package com.sargis.khlopuzyan.advancedandroid.inline_noinline_crossinline

private fun main() {
    callingFunction()
}

private fun callingFunction() {
    higherOrderFunction {
//        return  //Error. Can't return from here.
    }
}

inline fun higherOrderFunction(crossinline lambda: () -> Unit) {
    normalFunction {
        //TODO-IMPORTANT-INTERESTING
        lambda() //must mark lambda as crossinline to use in this context.
    }
}

fun normalFunction(lambda: () -> Unit) {
    return
}