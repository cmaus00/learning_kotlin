package org.kruste.delegation

import kotlin.reflect.KProperty

class SomeClass {
    var whatEver: String by ExternalProvider()
}

class ExternalProvider {
    var actualField = "myval"
    operator fun getValue(thisRef: SomeClass, property: KProperty<*>): String {
        return actualField
    }

    operator fun setValue(thisRef: SomeClass, property: KProperty<*>, value: String) {
        actualField = value
    }
}
