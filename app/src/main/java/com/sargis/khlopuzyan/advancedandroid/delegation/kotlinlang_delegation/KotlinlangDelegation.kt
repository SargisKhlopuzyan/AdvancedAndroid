package com.sargis.khlopuzyan.advancedandroid.delegation.kotlinlang_delegation

fun main() {
    val b = BaseImpl(10)
    val derived = Derived(b)
    derived.printMessage()
    println(derived.message)
}

interface Base {
    val message: String
    fun printMessage()
    fun printMessageLine()
}

open class BaseImpl(val x: Int) : Base {

    override val message = "BaseImpl: x = $x"

    override fun printMessage() {
        print(x)
    }

    override fun printMessageLine() {
        println(x)
    }
}

class Derived(b: Base) : Base by b {
    override fun printMessage() {
        print("abc")
    }
}