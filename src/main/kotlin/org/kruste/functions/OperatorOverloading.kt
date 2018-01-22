package org.kruste.functions

data class Time(val hours: Int, val minutes: Int) {
    operator fun plus(other: Time): Time {
        val newMins = minutes + other.minutes
        val newHours = newMins / 60

        return Time(hours + newHours + other.hours, newMins % 60)
    }
}

fun main(args: Array<String>) {
    println(Time(8,45) + Time(4, 30))
}