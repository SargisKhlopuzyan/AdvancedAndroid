package com.sargis.khlopuzyan.advancedandroid.delegation

fun main() {
    val myNameNotGood = NameDecorationNotGood("Tom")
    println(myNameNotGood.decoratedName) // Outputs: **TOM**

    myNameNotGood.decoratedName = "Marie"
    println(myNameNotGood.decoratedName) // Outputs: **MARIE**

    ///////////////////////////////////////////////////////////

    val myName = NameDecoration("Tom")

    println(myName.decoratedNameUppercaseName) // Outputs: **TOM**
    println(myName.decoratedLowercaseName) // Outputs: **tom**

    myName.decoratedNameUppercaseName = "Marie"
    myName.decoratedLowercaseName = "Marie"

    println(myName.decoratedNameUppercaseName) // Outputs: **MARIE**
    println(myName.decoratedLowercaseName) // Outputs: **marie**
}

private class NameDecorationNotGood(var name: String) {

    var decoratedName: String = name
        get() = "**${field.uppercase()}**"
        set(value) {
            field = value.uppercase()
        }
}

class NameDecoration(name: String) {
    var decoratedNameUppercaseName by Delegate(name) { it.uppercase() }
    var decoratedLowercaseName by Delegate(name) { it.lowercase() }
}