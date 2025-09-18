package com.sargis.khlopuzyan.advancedandroid.inlineNoinlineCrossinlineReified

private fun main() {
    genericFunction(ReifiedClass::class.java)
}

inline fun <reified T> genericFunction(c: Class<T>) {
    println(T::class.java) //OK
    println(c::class.java) //OK
}

//fun <T> genericFunction(c: Class<T>) {
//    println(c::class.java) //OK
//    println(T::class.java) //ERROR - Cannot use 'T' as reified type parameter. Use a class instead.
//}

//ERROR (inline is missing)
//fun <reified T> genericFunction(c: Class<T>) {
//    println(T::class.java) //OK
//    println(c::class.java) //OK
//}

class ReifiedClass