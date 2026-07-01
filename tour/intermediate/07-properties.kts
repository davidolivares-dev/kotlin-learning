#!/usr/bin/env kotlin

import kotlin.properties.Delegates.observable

// Exercise 1
// You manage an inventory system at a bookstore. The inventory is stored in a list where each item represents
// the quantity of a specific book. For example, listOf(3, 0, 7, 12) means the store has 3 copies of the first book,
// 0 of the second, 7 of the third, and 12 of the fourth.
//
// Write a function called findOutOfStockBooks() that returns a list of indices for all the books that are out of stock.
fun findOutOfStockBooks(inventory: List<Int>): List<Int> {
    // Write your code here
    val outOfStockBooks = mutableListOf<Int>()
    for (index in inventory.indices) {
        if (inventory[index] == 0) {
            outOfStockBooks.add(index)
        }
    }
    return outOfStockBooks
}

val inventory = listOf(3, 0, 7, 0, 5)
println(findOutOfStockBooks(inventory))
// [1, 3]

println()

// Exercise 2
// You have a travel app that needs to display distances in both kilometers and miles.
// Create an extension property for the Double type called asMiles to convert a distance in kilometers to miles:
val Double.asMiles: Double
    get() = this * 0.621371

val distanceKm = 5.0
println("$distanceKm km is ${distanceKm.asMiles} miles")
// 5.0 km is 3.106855 miles

val marathonDistance = 42.195
println("$marathonDistance km is ${marathonDistance.asMiles} miles")
// 42.195 km is 26.218757 miles

println()

// Exercise 3
// You have a system health checker that can determine the state of a cloud system.
// However, the two functions it can run to perform a health check are performance intensive.
// Use lazy properties to initialize the checks so that the expensive functions are only run when needed:
fun checkAppServer(): Boolean {
    println("Performing application server health check...")
    return true
}

fun checkDatabase(): Boolean {
    println("Performing database health check...")
    return false
}

// Write your code here
val isAppServerHealthy by lazy { checkAppServer() }
val isDatabaseHealthy by lazy { checkDatabase() }

when {
    isAppServerHealthy -> println("Application server is online and healthy")
    isDatabaseHealthy -> println("Database is healthy")
    else -> println("System is offline")
}
// Performing application server health check...
// Application server is online and healthy

println()

// Exercise 4
// You're building a simple budget tracker app. The app needs to observe changes to the user's remaining budget
// and notify them whenever it goes below a certain threshold. You have a `Budget` class that is initialized with a
// `totalBudget` property that contains the initial budget amount. Within the class, create an observable property
// called `remainingBudget` that prints:
// - A warning when the value is lower than 20% of the initial budget.
// - An encouraging message when the budget is increased from the previous value.
class Budget(val totalBudget: Int) {
    // Write your code here
    var remainingBudget: Int by observable(totalBudget) { _, oldValue, newValue ->
        if (newValue < totalBudget * 0.2) {
            println("Warning: Your remaining budget ($newValue) is below 20% of your total budget.")
        } else if (newValue > oldValue) {
            println("Good news: Your remaining budget increased to $newValue.")
        }
    }
}

val myBudget = Budget(totalBudget = 1000)
myBudget.remainingBudget = 800
myBudget.remainingBudget = 150
// Warning: Your remaining budget (150) is below 20% of your total budget.
myBudget.remainingBudget = 50
// Warning: Your remaining budget (50) is below 20% of your total budget.
myBudget.remainingBudget = 300
// Good news: Your remaining budget increased to 300.