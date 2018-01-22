package org.kruste.classes

sealed class Result

class Success(val content: String) : Result()
class Error(val code: Int, val message: String): Result()

fun doIt(x: Int): Result {
    if (x < 0) {
        return Error(x, "bad input")
    } else {
        return Success("right on!")
    }
}

fun main(args: Array<String>) {
    val doIt = doIt(23)
    when (doIt) {
        is Success -> println(doIt.content)
        is Error -> println(doIt.message)
    }
}