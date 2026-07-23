/*
 * Kotlin Koans — Collections #8: FlatMap
 *
 * Task: Return the products a customer ordered, and all products ordered by at
 * least one customer. flatMap is map + flatten: map { it.products } alone gives
 * List<List<Product>>, and flatMap concatenates the inner lists into one flat
 * List<Product>. Member references (Order::products) replace pure pass-through
 * lambdas like { it.products }. toSet() dedupes products across customers.
 */

// Return all products the given customer has ordered
fun Customer.getOrderedProducts(): List<Product> =
    orders.flatMap(Order::products)

// Return all products that were ordered by at least one customer
fun Shop.getOrderedProducts(): Set<Product> =
    customers.flatMap(Customer::getOrderedProducts).toSet()
