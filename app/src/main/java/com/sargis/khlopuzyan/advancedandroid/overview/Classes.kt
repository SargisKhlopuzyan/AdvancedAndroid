package com.sargis.khlopuzyan.advancedandroid.overview

private fun main() {
    val anonymousClass = object : AbstractClass1() {
        override val p1: Int = 2

        override fun doSomething() {

        }
    }

    val lambda: (Int, Float) -> String = { x: Int, y: Float ->
        "${x * y}"
    }

    val functionType: (Int, Float) -> String = ::myFunction
}

fun myFunction(x: Int, y: Float): String {
    return "${x * y}"
}

abstract class AbstractClass1 {
    abstract val p1: Int
    abstract fun doSomething()
}

sealed interface SealedInterface {
    val p1: Int
    fun doSomething()
}

sealed class SealedClass {
    open val p1: Int = 10
    open fun doSomething() {

    }
}

abstract class AbstractClass
abstract interface AbstractInterface

enum class EnumClass(val code: Int, val description: String) {
    A(0, "0"),
    B(0, "0"),
    C(0, "0");

    fun doSomething() {

    }
}

data class DataClass(val code: Int) {
    val decription: String = ""
}


//class NormalClass: DataClass(12) // Error - This type is final, so it cannot be extended.

data class DataClassChild(val code: Int) : SealedClass() {

    val decription: String = ""

    override val p1: Int = 2

    override fun doSomething() {

    }
}

class Outer {
    var p1: Int = 10

    class Nested {
//        var p2: Int = p1 // Error - Unresolved reference 'p1'
    }

    inner class Inner {
        var p2: Int = p1
    }
}

class View {
    val p1: Int = 0
    val clickListeners: MutableList<OnClickListener> = mutableListOf()

    fun function1() {

    }

    abstract inner class OnClickListener {
        fun onCLick() {

        }
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        clickListeners.add(onClickListener)
    }
}