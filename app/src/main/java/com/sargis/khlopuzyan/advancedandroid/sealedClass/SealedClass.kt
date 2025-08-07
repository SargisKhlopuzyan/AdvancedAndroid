package com.sargis.khlopuzyan.advancedandroid.sealedClass

fun main() {
//    val sealedClass = SealedClass() // Error - Cannot access 'constructor(): SealedClass': it is protected
//    val sealedClass = object : SealedClass() // Error - Anonymous object cannot extend a sealed class.

//    val sealedInterface = object : SealedInterface() // Error - Anonymous object cannot extend a sealed interface.
}

sealed class SealedClass {
    class A: SealedClass()
    class B: SealedClass()
}

sealed interface SealedInterface {
    class A: SealedInterface
    class B: SealedInterface
}