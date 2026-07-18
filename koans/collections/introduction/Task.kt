/*
 * Kotlin Koans — Collections #1: Introduction
 *
 * Task: Implement Shop.getSetOfCustomers() returning the shop's customers as a
 * Set. Kotlin collections are Java collections under the hood, exposed through
 * read-only or mutable views. The stdlib adds 'to'-prefixed converters like
 * toSet/toList that copy into a new collection (deduplicating for a Set).
 * Shop and its related classes live in Shop.kt.
 */

fun Shop.getSetOfCustomers(): Set<Customer> =
    customers.toSet()