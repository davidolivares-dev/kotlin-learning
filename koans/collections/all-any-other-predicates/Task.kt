/*
 * Kotlin Koans — Collections #4: All Any and other predicates
 *
 * Task: Implement four extension functions with all, any, count, find.
 * all  — true only if every element matches (vacuously true if empty).
 * any  — true if at least one matches (short-circuits on first hit).
 * count— number of elements matching the predicate.
 * find — first matching element or null (alias for firstOrNull), which is
 *        why findCustomerFrom returns Customer?.
 */

// Return true if all customers are from a given city
fun Shop.checkAllCustomersAreFrom(city: City): Boolean =
    customers.all { customer -> customer.city == city }

// Return true if there is at least one customer from a given city
fun Shop.hasCustomerFrom(city: City): Boolean =
    customers.any { customer -> customer.city == city }

// Return the number of customers from a given city
fun Shop.countCustomersFrom(city: City): Int =
    customers.count { customer -> customer.city == city }

// Return a customer who lives in a given city, or null if there is none
fun Shop.findCustomerFrom(city: City): Customer? =
    customers.find { customer -> customer.city == city }
