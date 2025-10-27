package com.sargis.khlopuzyan.advancedandroid.delegation.v2

import com.sargis.khlopuzyan.advancedandroid.delegation.medium.Delegate
import kotlin.reflect.KProperty

fun main() {
    val person = object : Person {
        override val name: String = "Name"
    }

    val man = Man(person)

    val nameDecoration = NameDecoration("Sargis")
    nameDecoration.decoratedName
    nameDecoration.decoratedUppercaseName
}

interface Person {
    val name: String
}

class Man(val person: Person) : Person by person {

}

class NameDecoration(val name: String) {
    val decoratedName by Delegate(name) {
        it.lowercase()
    }
    val decoratedUppercaseName by Delegate(name) {
        it.uppercase()
    }
}

class Delegate(initialValue: String, someFunction: (String) -> String) {

    private var storedValue: String = initialValue
    private val modify = someFunction

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return modify(storedValue)
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        storedValue = value
    }
}