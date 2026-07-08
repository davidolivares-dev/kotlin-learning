/*
 * Kotlin Koans — Introduction #8: Lambdas
 *
 * Task: Pass a lambda to the any function to check whether the collection
 * contains an even number.
 */

fun containsEven(collection: Collection<Int>): Boolean =
    collection.any { i -> i % 2 == 0 }