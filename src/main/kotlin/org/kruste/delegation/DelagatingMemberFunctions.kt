package org.kruste.delegation

data class Customer(val name: String)

interface Repository {
    fun getAll(): List<Customer>
    fun getByName(name: String): Customer?
}

class Dummyrepo : Repository {
    private val listOfCustomers: List<Customer> = listOf(
            Customer("a"),
            Customer("b"),
            Customer("c")
    )

    override fun getAll(): List<Customer> {
        return listOfCustomers
    }

    override fun getByName(name: String): Customer? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class Controller(repo: Repository) : Repository by repo {
    fun index(): String {
        return getAll().map { it -> it.name }.toString()
    }
}

fun main(args: Array<String>) {
    val c = Controller(Dummyrepo())
    println(c.index())
}