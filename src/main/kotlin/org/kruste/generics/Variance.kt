package org.kruste.generics

interface Factory<out T> {
    fun create(): T
}

open class A(val value: Int) {
    companion object : Factory<A> {
        override fun create(): A {
            return A(1)
        }
    }

    fun printValue() {
        println(value)
    }
}

class B(value: Int, val name: String) : A(value) {
    companion object : Factory<B> {
        override fun create(): B {
            return B(1, "narf!")
        }
    }

    fun printName() {
        println(name)
    }
}

class Identity<out T>(val value: T)

class Container<in T:Any> {
    lateinit private var el:T

    fun setElement(e:T) {
        el = e
    }
}

fun doPrint(id: Identity<A>) {
    id.value.printValue()
}

fun main(args: Array<String>) {
    val identity = Identity(B.create())
    doPrint(identity)

    val c = Container<A>()
    c.setElement(B.create())

}