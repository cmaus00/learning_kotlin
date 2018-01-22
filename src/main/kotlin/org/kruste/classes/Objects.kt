package org.kruste.classes

class NarfClass {
    companion object {
        fun foo() {
            println("foo")
        }
    }

    object whatElse {
        fun narf() {
            println("narf")
        }
    }
}

fun main(args: Array<String>) {
    println("bar")
    NarfClass.foo()
}