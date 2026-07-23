/*
 * Kotlin Koans — Collections #9: Max min
 *
 * Task: Return the customer with the most orders, and the given customer's most
 * expensive product. maxByOrNull/minByOrNull take a selector and return the
 * element with the largest/smallest derived value, or null on an empty
 * collection (hence the Product?/Customer? return). maxOrNull/minOrNull instead
 * compare elements by natural order. getMostExpensiveProductBy uses callable
 * references (Order::products, Product::price) in place of lambdas.
 */

// Return a customer who has placed the maximum amount of orders
fun Shop.getCustomerWithMaxOrders(): Customer? =
    customers.maxByOrNull { it.orders.size }

// Return the most expensive product that has been ordered by the given customer
fun getMostExpensiveProductBy(customer: Customer): Product? =
    customer.orders
        .flatMap(Order::products)
        .maxByOrNull(Product::price)
