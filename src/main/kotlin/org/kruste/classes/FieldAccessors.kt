package org.kruste.classes

class MyClass() {
    var whatEver: Int = 0
        get() = field
        set(value: Int) {
            if (value >= 0) {
                field = value
            }
        }
}


fun main(args: Array<String>) {
    var c = MyClass()
    println(c.whatEver)
    c.whatEver = 200
    println(c.whatEver)
    c.whatEver = -100
    println(c.whatEver)
}