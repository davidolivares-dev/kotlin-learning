#!/usr/bin/env kotlin

import kotlin.math.PI

// Functions Practice
// Exercise 1
// Write a function called circleArea that takes the radius of a circle in integer format as a parameter
// and outputs the area of that circle.
fun circleArea(radius: Int): Double {
    return PI * (radius * radius)
}

println(circleArea(2))

// Exercise 2
// Rewrite the circleArea function from the previous exercise as a single-expression function.
fun circleArea2(radius: Int) = PI * radius * radius

// Exercise 3
// You have a function that translates a time interval given in hours, minutes, and seconds into seconds.
// In most cases, you need to pass only one or two function parameters while the rest are equal to 0.
// Improve the function and the code that calls it by using default parameter values and named arguments
// so that the code is easier to read.
// fun intervalInSeconds(hours: Int, minutes: Int, seconds: Int) =
//     ((hours * 60) + minutes) * 60 + seconds
//
//  println(intervalInSeconds(1, 20, 15))
//  println(intervalInSeconds(0, 1, 25))
//  println(intervalInSeconds(2, 0, 0))
//  println(intervalInSeconds(0, 10, 0))
//  println(intervalInSeconds(1, 0, 1))
fun intervalInSeconds(hours: Int = 0, minutes: Int = 0, seconds: Int = 0) = ((hours * 60) + minutes) * 60 + seconds

println(intervalInSeconds(1, 20, 15))
println(intervalInSeconds(minutes = 1, seconds = 25))
println(intervalInSeconds(hours = 2))
println(intervalInSeconds(minutes = 10))
println(intervalInSeconds(hours = 1, seconds = 1))

println()

// Lambda Expressions Practice
// Exercise 1
// You have a list of actions supported by a web service, a common prefix for all requests,
// and an ID of a particular resource. To request an action title over the resource with ID: 5,
// you need to create the following URL: `https://example.com/book-info/5/title`.
// Use a lambda expression to create a list of URLs from the list of actions.
val actions = listOf("title", "year", "author")
val prefix = "https://example.com/book-info"
val id = 5
val urls = actions.map { action -> "$prefix/$id/$action" } // Write your code here
println(urls)

// Exercise 2
// Write a function that takes an `Int` value and an action (a function with type `() -> Unit`)
// which then repeats the action the given number of times. Then use this function to print “Hello” 5 times.
fun repeatN(n: Int, action: () -> Unit) {
    // Write your code here
    for (i in 1..n) {
        action()
    }
}

repeatN(5) {
    println("Hello")
}
