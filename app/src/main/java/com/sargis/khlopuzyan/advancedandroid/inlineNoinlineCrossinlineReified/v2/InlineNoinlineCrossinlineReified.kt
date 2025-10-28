package com.sargis.khlopuzyan.advancedandroid.inlineNoinlineCrossinlineReified.v2

fun main() {
    genericFunction(String::class.java)
    genericFunction(Int::class.java)
    genericFunction(Boolean::class.java)
}

private fun noInlineFunction(x: Int, callback: () -> Unit) {
    val cc = callback
}

private inline fun inlineFunction(x: Int, callback: () -> Unit) {
//    val cc = callback // Error
}

private inline fun crossInlineFunction(x: Int, crossinline callback: () -> Unit) {
//    val cc = callback // Error
}

private inline fun <reified T> genericFunction(c: Class<T>) {
    println(T::class.java)
}