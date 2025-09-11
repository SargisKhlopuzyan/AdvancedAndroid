package com.sargis.khlopuzyan.advancedandroid.delegation

import kotlin.reflect.KProperty

class Delegate(initialValue: String, someFunction: (String) -> String) {

    private var storedValue: String = initialValue

    private val modify = someFunction

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "**${modify(storedValue)}"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        storedValue = value
    }
}