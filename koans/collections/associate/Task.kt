/*
 * Kotlin Koans — Collections #5: Associate
 *
 * Task: Build maps from collections with associateBy, associateWith, associate.
 * associateBy   — lambda produces the key, element becomes the value.
 * associateWith — element becomes the key, lambda produces the value.
 * associate     — lambda returns the full key-to-value Pair (both sides).
 * Duplicate keys are last-write-wins: earlier entries are silently dropped.
 */

// Build a map from the customer name to the customer
fun Shop.nameToCustomerMap(): Map<String, Customer> =
    customers.associateBy { customer -> customer.name }

// Build a map from the customer to their city
fun Shop.customerToCityMap(): Map<Customer, City> =
    customers.associateWith { customer -> customer.city }

// Build a map from the customer name to their city
fun Shop.customerNameToCityMap(): Map<String, City> =
    customers.associate { it.name to it.city}