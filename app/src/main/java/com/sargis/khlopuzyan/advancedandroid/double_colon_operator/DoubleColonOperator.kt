package com.sargis.khlopuzyan.advancedandroid.double_colon_operator

import kotlin.reflect.KClass

private fun main() {
    val customClass = CustomClass("MyName")

    val result1: KClass<out KClass<CustomClass>> = classReference::class
    val result2: Unit = constructorReference("Hi")
    val result3: String = classPropertyReference(CustomClass(""))
    val result4: Unit = functionReference("Hi")
    val result5: Int = propertyReference()

//    classPropertyReference.get(customClass)
//    classPropertyReference.set(customClass, "NewName")
}

private class CustomClass(var name: String) {
//    constructor(): this("") {}
}

private fun printMessage(message: String) {
    println(message)
}

private val age: Int = 15

/***************************/

private val classReference: KClass<CustomClass> = CustomClass::class // Reference to the MyClass class

private val constructorReference: (String) -> Unit = ::CustomClass
//private val constructorReference1: () -> Unit = ::CustomClass
private val constructorReference2 = ::CustomClass

private val classPropertyReference: (CustomClass) -> String = CustomClass::name

private val functionReference: (String) -> Unit = ::printMessage
private val functionReference2 = ::printMessage

private val propertyReference: () -> Int = ::age
private val propertyReference2 = ::age
