#!/usr/bin/env kotlin

// Exercise 1
// Write an extension function called `isPositive` that takes an integer and checks whether it is positive.
fun Int.isPositive(): Boolean = this > 0

println(1.isPositive())

// Exercise 2
// Write an extension function called `toLowercaseString` that takes a string and returns a lowercase version.
fun String.toLowercaseString(): String = this.lowercase()

println("Hello World!".toLowercaseString())
