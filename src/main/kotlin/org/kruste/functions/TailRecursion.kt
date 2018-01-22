package org.kruste.functions

tailrec fun factorial(n:Int, accumulator: Int = 1): Int {
    when (n) {
        0 -> return accumulator
        else -> return factorial(n-1, accumulator * n)
    }
}

fun main(args: Array<String>) {
    println(factorial(5))
}