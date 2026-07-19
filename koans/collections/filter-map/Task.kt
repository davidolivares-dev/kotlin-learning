/*
 * Kotlin Koans — Collections #3: Filter map
 *
 * Task: Implement two extension functions with map and filter.
 * map transforms each element (customer -> city) into a new collection;
 * filter keeps only elements matching a predicate. Both return new lists.
 * getCustomerCities maps to cities then toSet() to dedupe; getCustomersFrom
 * filters by structural equality (City is a data class, so == compares value).
 */

// Find all the different cities the customers are from
fun Shop.getCustomerCities(): Set<City> =
        customers.map { customer -> customer.city }.toSet()

// Find the customers living in a given city
fun Shop.getCustomersFrom(city: City): List<Customer> =
        customers.filter { customer -> customer.city == city }