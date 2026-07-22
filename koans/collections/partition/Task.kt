/*
 * Kotlin Koans — Collections #7: Partition
 *
 * Task: Return customers who have more undelivered orders than delivered ones.
 * partition splits a collection into a Pair<List, List>: first holds elements
 * the predicate returned true for, second the rest. The (delivered, undelivered)
 * destructuring is positional (component1/component2), so the name order must
 * match the predicate — here partition { it.isDelivered } puts delivered first.
 */

// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> =
    customers.filter { customer ->
        val (delivered, undelivered) = customer.orders.partition { it.isDelivered }
        undelivered.size > delivered.size
    }.toSet()
