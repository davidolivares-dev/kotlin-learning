/*
 * Kotlin Koans — Collections #2: Sort
 *
 * Task: Return the shop's customers sorted in descending order by how many
 * orders each has made. sortedByDescending takes a selector and returns a new
 * List, leaving the original untouched — unlike the in-place sortByDescending
 * on a MutableList (which returns Unit). Other variants: sorted /
 * sortedDescending (natural order), sortedBy (ascending by selector).
 */

fun Shop.getCustomersSortedByOrders(): List<Customer> =
    customers.sortedByDescending { customer -> customer.orders.size }

