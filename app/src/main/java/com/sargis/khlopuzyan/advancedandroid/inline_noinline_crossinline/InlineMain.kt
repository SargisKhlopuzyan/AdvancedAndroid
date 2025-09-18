package com.sargis.khlopuzyan.advancedandroid.inline_noinline_crossinline

private fun main() {
    callingFunction()
}

private fun callingFunction() {
    higherOrderInlineFunction {
        print("Non-local control flow")
        // TODO-IMPORTANT - Non-local control flow
        return
    }
}


private val privateMemberVariable = "I'm private"

@PublishedApi
internal val internalMemberVariable = "I'm internal"

val publicMemberVariable = "I'm public"

inline fun higherOrderInlineFunction(lambda: () -> Unit) {

    //ERROR: can't access this variable in an inline function.
//    privateMemberVariable.length

    /**
     * InCase internalMemberVariable isn't internal and haven't been marked @PublishedApi:
     *
     * '@PublishedApi' annotation is only applicable to internal declaration.
     * Public-API inline function cannot access non-public-API property.
     * */
    //Can access this variable because it's marked with @PublishedApi and internal
    internalMemberVariable.length

    //Can access this variable, it's public
    publicMemberVariable.length

//    doSomething()
    lambda.invoke()
//    doAnotherThing()
}

fun nonInlineFunction(lambda: () -> Unit) {

    //Can access this variable in a non inline function.
    privateMemberVariable.length

    //Can access this variable in a non inline function.
    internalMemberVariable.length

    //Can access this variable, it's public
    publicMemberVariable.length

//    doSomething()
    lambda.invoke()
//    doAnotherThing()

    print("I won't be executed when you call callingFunction() as there is RETURN in lambda")
}