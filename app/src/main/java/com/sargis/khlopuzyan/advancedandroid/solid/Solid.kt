package com.sargis.khlopuzyan.advancedandroid.solid

/**
 * SOLID
 *
 * SRP - Single Responsibility Principle:
 *      SRP dictates that a class or module should have only one reason to change.
 *      In other words, it should have only one responsibility or job.
 *      This principle, part of the SOLID design principles, promotes modularity,
 *      making code easier to understand, maintain, and modify.
 *
 * OCP - Open/Closed Principle:
 *      OCP states that software entities (classes, modules, functions, etc.)
 *      should be open for extension but closed for modification.
 *      This means you should be able to add new functionality without altering existing, tested code.
 *
 * Liskov Substitution Principle:
 *      LSP ensures subtypes can be used in place of their supertypes without altering the correctness of the program.
 *      Essentially, if a program works with a base class, it should also work correctly when a subclass is used instead.
 *      This principle is crucial for maintaining the integrity and predictability of software systems when using inheritance.
 *
 * ISP - Interface Segregation Principle:
 *      ISP states that clients should not be forced to depend on interfaces they do not use.
 *      Essentially, it advocates for breaking down large, general-purpose interfaces into smaller,
 *      more specific ones, ensuring that classes only implement the methods they actually need.
 *
 * DIP - Dependency Inversion Principle:
 *      DIP states that high-level modules should not depend on low-level modules.
 *      Instead, both should depend on abstractions.
 *      Additionally, abstractions should not depend on details; details should depend on abstractions.
 * */
private fun main() {

}

interface PaymentProcessingHistory {
    fun printHistory()
}

interface PaymentProcessing {
    fun pay()
}

open class PaymentProcessor : PaymentProcessing {
    override fun pay() {
        println("Paying by Credit Card")
    }
}

class PayPalPaymentProcessor : PaymentProcessing, PaymentProcessingHistory {
    override fun pay() {
        println("Paying by PayPal")
    }

    override fun printHistory() {
        println("Printing PayPal history")
    }
}

class StripePaymentService: PaymentProcessor() {

}