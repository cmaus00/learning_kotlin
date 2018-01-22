package org.kruste.functions

fun outer(pOuter:String) {
    val foo = "bar"

    fun inner(pInner:String) {
        println(pOuter)
        println(pInner)
    }
    inner(foo)
}

fun main(params:Array<String>) {
    outer("Narf!")
}