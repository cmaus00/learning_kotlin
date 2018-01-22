package org.kruste.generics

import java.io.Serializable

open class Entity(val id: Int)

class Customer(id:Int):Entity(id), Serializable
class Repository<T> where T:Entity, T:Serializable{
    fun save(entity: T) {
        if (entity.id != 0) {

        }
    }
}

fun main(args: Array<String>) {
    val repo = Repository<Customer>()

}