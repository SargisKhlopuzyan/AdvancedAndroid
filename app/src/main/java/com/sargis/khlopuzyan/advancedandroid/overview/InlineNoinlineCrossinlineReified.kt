package com.sargis.khlopuzyan.advancedandroid.overview

//TODO-URL : https://www.youtube.com/watch?v=8i-_z__AEsw

private fun main() {
    saveAllData("AA", "BBB", "CCCC", "DDDDD")

    myGenericType(String::class.java)
}

fun saveAllData(vararg data: String) {
    for (item in data) {
        checkValidity(
            item,
            {
                //inline
                return
                return@checkValidity
            },
            {
                //noinline
//                return // Error - 'return' is prohibited here.
                return@checkValidity
            },
            {
                //crossinline
//                if (item.startsWith("C")) {
//                    return@checkValidity
//                }
                save(item)

//                return // Error - 'return' is prohibited here.
                return@checkValidity
            }
        )
    }
}

private inline fun checkValidity(
    item: String,
    onError: () -> Unit,
    crossinline onFail: () -> Unit,
    noinline onValidSuccess: () -> Unit,
) {
    if (item.length > 3) {
        println("$item is valid")

//        val error = onError // Error - Illegal usage of inline parameter 'onError: () -> Unit'. Add 'noinline' modifier to the parameter declaration.
//        val fail = onFail // Error - Illegal usage of inline parameter 'crossinline onFail: () -> Unit'. Add 'noinline' modifier to the parameter declaration.
        val success = onValidSuccess

        otherInline(onError)
        otherInline(onFail)
        otherInline(success)
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        otherCrossinline(onError) // Error - Cannot inline 'onError: () -> Unit' here: it might contain non-local returns. Add 'crossinline' modifier to parameter declaration 'onError: () -> Unit'
        otherCrossinline(onFail)
        otherCrossinline(success)
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        otherNoinline(onError) // Error - Illegal usage of inline parameter 'onError: () -> Unit'. Add 'noinline' modifier to the parameter declaration.
//        otherNoinline(onFail) // Error - Illegal usage of inline parameter 'crossinline onFail: () -> Unit'. Add 'noinline' modifier to the parameter declaration.
        otherNoinline(success)


        onValidSuccess()
        println("$item valid Success called")
    }
}

private fun save(item: String) {
    println("$item saved")
}

private inline fun otherInline(lambda: () -> Unit) {
    lambda()
}

private inline fun otherCrossinline(crossinline lambda: () -> Unit) {
    lambda()
}

private fun otherNoinline(lambda: () -> Unit) {
    lambda()
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

inline fun<reified T> myGenericType(c: Class<T>) {
    println(T::class.java.name)
}