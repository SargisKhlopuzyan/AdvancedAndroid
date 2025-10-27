package com.sargis.khlopuzyan.advancedandroid.reference_types

import java.lang.ref.SoftReference
import java.lang.ref.WeakReference

private fun main() {
    val person = Person("Sargis", 36) // Strong reference
    val softReference = SoftReference<Person>(person)
    val softReference2 = SoftReference<Person>(Person("", 0))

    val weakReference = WeakReference<Person>(person)
    val weakReference2 = WeakReference<Person>(Person("", 0))
}

data class Person(
    var name: String,
    var age: Int,
)