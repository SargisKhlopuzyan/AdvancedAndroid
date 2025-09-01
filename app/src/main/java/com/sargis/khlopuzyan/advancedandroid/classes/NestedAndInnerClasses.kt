package com.sargis.khlopuzyan.advancedandroid.classes

//TODO-URL : https://kotlinlang.org/docs/nested-classes.html#inner-classes

val nested = OuterClass.NestedClass().nestedFunction()
//val inner = Outer.InnerClass().innerFunction() //Error

/******************************************/

class OuterClass {
    private var outerProperty: Int = 1

    class NestedClass {
//        val nestedProperty: Int = outerProperty //Error

        fun nestedFunction() {
        }
    }

    inner class InnerClass {
        val innerProperty: Int = outerProperty

        fun innerFunction() {
        }
    }

    interface NestedInterface {
    }

    //Error - Modifier 'inner' is not applicable to 'interface'.
//    inner interface InnerInterface {
//    }
}

interface OuterInterface {

    var outerProperty: Int

    class NestedClass {
//        val nestedProperty: Int = outerProperty //Error

        fun nestedFunction() {
        }
    }

    //Error - Modifier 'inner' is not applicable inside 'interface'.
//    inner class InnerClass {
//        val innerProperty: Int = outerProperty
//
//        fun innerFunction() {
//        }
//    }

    interface NestedInterface {
//        val nestedProperty: Int = outerProperty //Error

        fun nestedFunction() {
        }
    }

    //Error - Modifier 'inner' is not applicable to 'interface'.
//    inner interface InnerInterface {
//        val innerProperty: Int = outerProperty
//
//        fun innerFunction() {
//        }
//    }
}