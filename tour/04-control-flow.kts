#!/usr/bin/env kotlin

import kotlin.random.Random

// Conditional Expressions Practice
// Exercise 1
// Create a simple game where you win if throwing two dice results in the same number.
// Use `if` to print `You win :)` if the dice match or `You lose :(` otherwise.
val firstResult = Random.nextInt(6)
val secondResult = Random.nextInt(6)

if (firstResult == secondResult) {
    println("You win :)")
} else {
    println("You lose :(")
}

// Exercise 2
// Using a `when` expression, update the following program so that it prints the corresponding actions
// when you input the names of game console buttons.
// val button = "A"
//
// println(
//     // Write your code here
// )

val button = "A"

println(
    when (button) {
        "A" -> "Yes"
        "B" -> "No"
        "X" -> "Menu"
        "Y" -> "Nothing"
        else -> "There is no such button"
    }
)

// Loops Practice
// Exercise 1
// You have a program that counts pizza slices until there's a whole pizza with 8 slices.
// Refactor this program in two ways:
// var pizzaSlices = 0
// // Start refactoring here
// pizzaSlices++
// println("There's only $pizzaSlices slice/s of pizza :(")
// pizzaSlices++
// println("There's only $pizzaSlices slice/s of pizza :(")
// pizzaSlices++
// println("There's only $pizzaSlices slice/s of pizza :(")
// pizzaSlices++
// println("There's only $pizzaSlices slice/s of pizza :(")
// pizzaSlices++
// println("There's only $pizzaSlices slice/s of pizza :(")
// pizzaSlices++
// println("There's only $pizzaSlices slice/s of pizza :(")
// pizzaSlices++
// println("There's only $pizzaSlices slice/s of pizza :(")
// pizzaSlices++
// // End refactoring here
// println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
var pizzaSlices = 0
while (pizzaSlices++ < 7) {
    println("There's only $pizzaSlices slice/s of pizza :(")
}
println("There are $pizzaSlices slices of Pizza. Hooray! We have a whole pizza! :D")

// Exercise 2
// Write a program that simulates the Fizz buzz game.
// our task is to print numbers from 1 to 100 incrementally, replacing any number divisible by three
// with the word "fizz", and any number divisible by five with the word "buzz".
// Any number divisible by both 3 and 5 must be replaced with the word "fizzbuzz".
// using `if`
for (number in 1..100) {
    if (number % 3 == 0 && number % 5 == 0) {
        println("fizzbuzz")
    } else if (number % 3 == 0) {
        println("fizz")
    } else if (number % 5 == 0) {
        println("buzz")
    } else {
        println("$number")
    }
}
println("\n======\n")
// Using `when`
for (number in 1..100) {
    println(
        when {
            number % 15 == 0 -> "fizzbuzz"
            number % 3 == 0 -> "fizz"
            number % 5 == 0 -> "buzz"
            else -> "$number"
        }
    )
}

println()

// Exercise 3
// You have a list of words. Use `for` and `if` to print only the words that start with the letter l.
val words = listOf("dinosaur", "limousine", "magazine", "language")
for (word in words) {
    if (word.startsWith("l")) {
        println(word)
    }
}

