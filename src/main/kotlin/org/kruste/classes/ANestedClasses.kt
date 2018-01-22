package org.kruste.classes

class Outer(private val name: String) {

    class Nested {
        fun what() {
            //no access to instance variable
        }
    }
    inner class Inner() {
        fun what():Boolean {
            return name == "what"
        }
    }

    private class Nested2 {

    }
}

fun main(args: Array<String>) {
    val o = Outer("narf")
    o.Inner()
}