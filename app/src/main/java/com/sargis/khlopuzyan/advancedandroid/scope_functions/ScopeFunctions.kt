package com.sargis.khlopuzyan.advancedandroid.scope_functions

fun main() {
    val x: Int by lazy {
        12
    }

    val apply = x.apply {
        this
        this
    }

    val also = x.also {
        it
        it //this
    }

    val run = x.run {
        this
        {}
    }

    val run2 = run {
        {}
    }

    val with = with(x) {
        this
        {}
    }

    val let = x.let {
        it
        {}
    }
}