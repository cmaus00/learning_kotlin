package org.kruste.functions

/**
 * infix only possible for functions with a single parameter (obviously)
 */
infix fun String.shouldBeEqualTo(p : String) = this == p


fun main(p : Array<String>) {
    val output = "Hello"
    println(output shouldBeEqualTo "Hello")
}