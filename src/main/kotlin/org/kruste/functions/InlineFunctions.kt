package org.kruste.functions

inline fun operation(op: () -> Unit) {
    println("Before")
    op()
    println("After")
}

/**
 * not possible to inline because reference to lambda parameter
 */
inline fun tryingToInline(noinline op: () -> Unit) {
    val ref = op
    println("Narf")
    op()
}

fun main(args: Array<String>) {
    operation { println("in op") }
}