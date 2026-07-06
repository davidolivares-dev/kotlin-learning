#!/usr/bin/env kotlin
import kotlin.math.*
import kotlin.time.measureTime

// Exercise 1
// You are developing a financial application that helps users calculate the future value of their investments.
// The formula to calculate compound interest is:
//
// A = P x (1 + r/n) ^ nt
//
// Where:
// - A is the amount of money accumulated after interest (principal + interest).
// - P is the principal amount (the initial investment).
// - r is the annual interest rate (decimal).
// - n is the number of times interest is compounded per year.
// - t is the time the money is invested for (in years).
//
// Update the code to:
// 1. Import the necessary functions from the kotlin.math package.
// 2. Add a body to the `calculateCompoundInterest()` function that calculates the final amount after applying
// compound interest.
fun calculateCompoundInterest(P: Double, r: Double, n: Int, t: Int): Double {
    return P * (1 + r / n).pow(n * t)
}

val principal = 1000.0
val rate = 0.05
val timesCompounded = 4
val years = 5
val amount = calculateCompoundInterest(principal, rate, timesCompounded, years)
println("The accumulated amount is: $amount")
// The accumulated amount is: 1282.0372317085844

println()

// Exercise 2
// You want to measure the time it takes to perform multiple data processing tasks in your program.
// Update the code to add the correct import statements and functions from the kotlin.time package:
val timeTaken = measureTime {
    // Simulate some data processing
    val data = List(1000) { it * 2 }
    val filteredData = data.filter { it % 3 == 0 }

    // Simulate processing the filtered data
    val processedData = filteredData.map { it / 2 }
    println("Processed data")
}

println("Time taken: $timeTaken") // e.g. 16 ms

println()

// Exercise 3
// There's a new feature in the standard library available in the latest Kotlin release.
// You want to try it out, but it requires opt-in. The feature falls under @ExperimentalStdlibApi.
// What should the opt-in look like in your code?

// @OptIn(ExperimentalStdlibApi::class)