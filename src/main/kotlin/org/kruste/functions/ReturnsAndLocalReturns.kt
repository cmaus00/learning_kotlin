package org.kruste.functions

/**
 * non-local return (without label) is only possible because the higher order function (forEch) is inlined
 */
fun containingFunction() {
    (1..100).forEach divisiveTest@{
        if (it % 5 == 0) {
            return@divisiveTest
        }
    }
    println("Hello")
}

fun main(args: Array<String>) {
    containingFunction()
}