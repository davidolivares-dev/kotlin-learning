#!/usr/bin/env kotlin

// Exercise 1
// You manage a delivery service and need a way to track the status of packages. Create a sealed class called
// `DeliveryStatus`, containing data classes to represent the following statuses: `Pending`, `InTransit`, `Delivered`,
// `Canceled`. Complete the `DeliveryStatus` class declaration so that the code runs successfully:
sealed class DeliveryStatus { // Write your code here
    data class Pending(val sender: String) : DeliveryStatus()
    data class InTransit(val estimatedDeliveryDate: String) : DeliveryStatus()
    data class Delivered(val deliveryDate: String, val recipient: String) : DeliveryStatus()
    data class Canceled(val reason: String) : DeliveryStatus()
}

fun printDeliveryStatus(status: DeliveryStatus) {
    when (status) {
        is DeliveryStatus.Pending -> {
            println("The package is pending pickup from ${status.sender}.")
        }
        is DeliveryStatus.InTransit -> {
            println("The package is in transit and expected to arrive by ${status.estimatedDeliveryDate}.")
        }
        is DeliveryStatus.Delivered -> {
            println("The package was delivered to ${status.recipient} on ${status.deliveryDate}.")
        }
        is DeliveryStatus.Canceled -> {
            println("The delivery was canceled due to: ${status.reason}.")
        }
    }
}

val status1: DeliveryStatus = DeliveryStatus.Pending("Alice")
val status2: DeliveryStatus = DeliveryStatus.InTransit("2024-11-20")
val status3: DeliveryStatus = DeliveryStatus.Delivered("2024-11-18", "Bob")
val status4: DeliveryStatus = DeliveryStatus.Canceled("Address not found")

printDeliveryStatus(status1)
// The package is pending pickup from Alice.
printDeliveryStatus(status2)
// The package is in transit and expected to arrive by 2024-11-20.
printDeliveryStatus(status3)
// The package was delivered to Bob on 2024-11-18.
printDeliveryStatus(status4)
// The delivery was canceled due to: Address not found.

println()

// Exercise 2
// In your program, you want to be able to handle different statuses and types of errors. You have a sealed class
// to capture the different statuses which are declared in data classes or objects. Complete the code below by
// creating an enum class called `Problem` that represents the different problem types: `NETWORK`, `TIMEOUT`,
// and `UNKNOWN`.
sealed class Status {
    data object Loading : Status()
    data class Error(val problem: Problem) : Status() {
        enum class Problem { // Write your code here
            NETWORK,
            TIMEOUT,
            UNKNOWN
        }
    }

    data class OK(val data: List<String>) : Status()
}

fun handleStatus(status: Status) {
    when (status) {
        is Status.Loading -> println("Loading...")
        is Status.OK -> println("Data received: ${status.data}")
        is Status.Error -> when (status.problem) {
            Status.Error.Problem.NETWORK -> println("Network issue")
            Status.Error.Problem.TIMEOUT -> println("Request timed out")
            Status.Error.Problem.UNKNOWN -> println("Unknown error occurred")
        }
    }
}

val stat1: Status = Status.Error(Status.Error.Problem.NETWORK)
val stat2: Status = Status.OK(listOf("Data1", "Data2"))

handleStatus(stat1)
// Network issue
handleStatus(stat2)
// Data received: [Data1, Data2]