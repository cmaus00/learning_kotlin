package org.kruste.functions

fun op(x: Int, f: (Int) -> Int): Int {
    return f(x)
}

fun main(args: Array<String>) {
    println(op(3, { it:Int -> it * it }))
    println(op(3, fun(x): Int {
        //multiple return types are not possible with lambdas
        if (x > 10) {
            return 0
        } else {
            return x * x
        }
    }))
}