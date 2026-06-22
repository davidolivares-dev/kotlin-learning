#!/usr/bin/env kotlin

// Exercise 1
// You run a coffee shop and have a system for tracking customer orders.
// Consider the code below and complete the declaration of the second data object so that the following code
// runs successfully:
interface Order {
    val orderId: String
    val customerName: String
    val orderTotal: Double
}

data object OrderOne: Order {
    override val orderId = "001"
    override val customerName = "Alice"
    override val orderTotal = 15.50
}

data object OrderTwo: Order { // Write your code here
    override val orderId = "002"
    override val customerName = "Bob"
    override val orderTotal = 12.50
}

// Print the name of each data object
println("Order name: $OrderOne")
// Order name: OrderOne
println("Order name: $OrderTwo")
// Order name: OrderTwo

// Check if the orders are identical
println("Are the two orders identical? ${OrderOne == OrderTwo}")
// Are the two orders identical? false

if (OrderOne == OrderTwo) {
    println("The orders are identical.")
} else {
    println("The orders are unique.")
    // The orders are unique.
}

println("Do the orders have the same customer name? ${OrderOne.customerName == OrderTwo.customerName}")
// Do the orders have the same customer name? false

println()

// Exercise 2
// Create an object declaration that inherits from the Vehicle interface to create a unique
// vehicle type: FlyingSkateboard. Implement the name property and the move() function in your object so that
// the following code function runs successfully:
interface Vehicle {
    val name: String
    fun move(): String
}

object FlyingSkateboard : Vehicle { // Write your code here
    override val name = "Flying Skateboard"
    override fun move() = "Glides through the air with a hover engine"

    fun fly(): String = "Woooooooo"
}

println("${FlyingSkateboard.name}: ${FlyingSkateboard.move()}")
// Flying Skateboard: Glides through the air with a hover engine
println("${FlyingSkateboard.name}: ${FlyingSkateboard.fly()}")
// Flying Skateboard: Woooooooo

println()

// Exercise 3
// You have an app where you want to record temperatures. The class itself stores the information in Celsius,
// but you want to provide an easy way to create an instance in Fahrenheit as well.
// Complete the data class so that the following code function runs successfully:
data class Temperature(val celsius: Double) {
    val fahrenheit: Double = celsius * 9 / 5 + 32

    // Write your code here
    companion object {
        fun fromFahrenheit(fahrenheit: Double): Temperature = Temperature((fahrenheit - 32) * 5 / 9)
    }
}

val fahrenheit = 90.0
val temp = Temperature.fromFahrenheit(fahrenheit)
println("${temp.celsius}°C is $fahrenheit °F")
// 32.22222222222222°C is 90.0 °F