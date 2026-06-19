#!/usr/bin/env kotlin

// Exercise 1
// You have a `fetchData()` function that accepts a lambda expression with receiver.
// Update the lambda expression to use the `append()` function so that the output of your code is:
// "Data received - Processed."
fun fetchData(callback: StringBuilder.() -> Unit) {
    val builder = StringBuilder("Data received")
    builder.callback()
}

fetchData {
    // Write your code here
    append(" - Processed.")
    // Data received - Processed
    println(this.toString())
}

// Exercise 2
// You have a `Button` class and `ButtonEvent` and `Position` data classes.
// Write some code that triggers the `onEvent()` member function of the `Button` class to trigger a double-click event.
// Your code should print `"Double click!"`.
class Button {
    fun onEvent(action: ButtonEvent.() -> Unit) {
        // Simulate a double-click event (not a right-click)
        val event = ButtonEvent(isRightClick = false, amount = 2, position = Position(100, 200))
        event.action() // Trigger the event callback
    }
}

data class ButtonEvent(
    val isRightClick: Boolean,
    val amount: Int,
    val position: Position
)

data class Position(
    val x: Int,
    val y: Int
)

val button = Button()

button.onEvent {
    if (!isRightClick && amount == 2) {
        println("Double click!")
    }
}

// Exercise 3
// Write a function that creates a copy of a list of integers where every element is incremented by 1.
// Use the provided function skeleton that extends List<Int> with an incremented function.
fun List<Int>.incremented(): List<Int> {
    val originalList = this
    return buildList {
        // Write your code here
        // for (n in originalList) add(n + 1)
        addAll(originalList.map { v -> v+1 })
    }
}

val originalList = listOf(1, 2, 3)
val newList = originalList.incremented()
println(newList)
// [2, 3, 4]

