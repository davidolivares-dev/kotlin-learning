/*
 * Kotlin Koans — Introduction #7: Nothing type
 *
 * Task: Specify the Nothing return type for failWithWrongAge. Without it,
 * checkAge doesn't compile because the compiler assumes age can still be null
 * after the call.
 */

import java.lang.IllegalArgumentException

fun failWithWrongAge(age: Int?): Nothing {
    throw IllegalArgumentException("Wrong age: $age")
}

fun checkAge(age: Int?) {
    if (age == null || age !in 0..150) failWithWrongAge(age)
    println("Congrats! Next year you'll be ${age + 1}.")
}

fun main() {
    checkAge(10)
}