package com.sargis.khlopuzyan.advancedandroid.inlineNoinlineCrossinlineReified

//TODO-URL: https://www.youtube.com/watch?v=8i-_z__AEsw&ab_channel=SagarMalhotra
fun main() {
    saveAllData("Sargis", "Android", "X", "B")
}

private fun saveAllData(vararg data: String) {
    for (item in data) {
        checkValidity(
            item,
            onError = {
//                return //OK
//                return@checkValidity //OK
            },
            onFailure = {
//                return //ERROR
//                return@checkValidity //OK
            }
        ) {
            println("123")
            if (item.startsWith("X")) {
                return@checkValidity
            }
            save(item)
        }
    }
}

private inline fun checkValidity(
    item: String,
    onError: () -> Unit,
    crossinline onFailure: () -> Unit,
    noinline onValidSuccess: () -> Unit,
) {
    if (item.length > 3) {
        println("$item is valid")
//        val x = onError //ERROR
//        val y = onFailure //ERROR
//        val z = onValidSuccess //OK
        onError()
        onFailure()

//        //ERROR - Cannot inline 'onError: () -> Unit' here: it might contain non-local returns. Add 'crossinline' modifier to parameter declaration 'onError: () -> Unit'
//        val xx = {
//            onError()
//        }
//
//        //OK
//        val yy = {
//            onFailure()
//        }
//
//        //OK
//        val zz = {
//            onValidSuccess()
//        }

        onValidSuccess()
        println("$item valid Success called")
    } else {
        println("$item is invalid")
    }
}

private fun save(item: String) {
    println("$item saved")
}