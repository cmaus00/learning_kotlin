package org.kruste.delegation

import kotlin.properties.Delegates

class Host {
    var prop:String by Delegates.observable("", {prop, old, new ->
        println("changed ${prop.name} from ${old} to ${new}")
    })
}

fun main(args: Array<String>) {
    val h = Host()
    h.prop = "abcd"
    h.prop = "defg"
}