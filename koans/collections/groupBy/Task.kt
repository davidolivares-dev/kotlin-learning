/*
 * Kotlin Koans — Collections #6: GroupBy
 *
 * Task: Use groupBy to build a map of the customers living in each city.
 * groupBy applies the key selector to every element and collects ALL elements
 * sharing a key into a List — Map<City, List<Customer>>. Contrast associateBy,
 * which keeps only one value per key (last-write-wins); groupBy keeps them all.
 */

// Build a map that stores the customers living in a given city
fun Shop.groupCustomersByCity(): Map<City, List<Customer>> =
    customers.groupBy { customer -> customer.city }
