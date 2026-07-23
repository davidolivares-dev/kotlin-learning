/*
 * Kotlin Koans — Collections #10: Sum
 *
 * Task: Total the money a customer spent — the sum of prices across all ordered
 * products, counting each product once per time it was ordered. flatMap keeps
 * duplicates (no toSet), so repeats are counted; sumOf maps each Product to its
 * price and sums the Doubles in one step. Plain sum() applies when the elements
 * are already numbers; sumOf converts first.
 */

// Return the sum of prices for all the products ordered by a given customer
fun moneySpentBy(customer: Customer): Double =
    customer.orders.flatMap { it.products }.sumOf { it.price }
