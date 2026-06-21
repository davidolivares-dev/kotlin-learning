#!/usr/bin/env kotlin

// Exercise 1
// Imagine you're working on a smart home system. A smart home typically has different types of devices
// that all have some basic features but also unique behaviors. In the code sample below, complete the
// abstract class called SmartDevice so that the child class SmartLight can compile successfully.
//
// Then, create another child class called SmartThermostat that inherits from the SmartDevice class and implements
// turnOn() and turnOff() functions that return print statements describing which thermostat is heating or turned off.
// Finally, add another function called adjustTemperature() that accepts a temperature measurement as an input
// and prints: $name thermostat set to $temperature°C.
abstract class SmartDevice(val name: String) { // Write your code here
    abstract fun turnOn()
    abstract fun turnOff()
}

class SmartLight(name: String) : SmartDevice(name) {
    override fun turnOn() {
        println("$name is now ON.")
    }

    override fun turnOff() {
        println("$name is now OFF.")
    }

    fun adjustBrightness(level: Int) {
        println("Adjusting $name brightness to $level%.")
    }
}

class SmartThermostat(name: String) : SmartDevice(name) { // Write your code here
    override fun turnOn() {
        println("$name thermostat is now heating.")
    }

    override fun turnOff() {
        println("$name thermostat is now off.")
    }

    fun adjustTemperature(temperature: Int) {
        println("$name thermostat set to $temperature°C.")
    }
}

val livingRoomLight = SmartLight("Living Room Light")
val bedroomThermostat = SmartThermostat("Bedroom Thermostat")

livingRoomLight.turnOn()
// Living Room Light is now ON.
livingRoomLight.adjustBrightness(10)
// Adjusting Living Room Light brightness to 10%.
livingRoomLight.turnOff()
// Living Room Light is now OFF.

bedroomThermostat.turnOn()
// Bedroom Thermostat thermostat is now heating.
bedroomThermostat.adjustTemperature(5)
// Bedroom Thermostat thermostat set to 5°C.
bedroomThermostat.turnOff()
// Bedroom Thermostat thermostat is now off.

println()

// Exercise 2
// Create an interface called `Media` that you can use to implement specific media classes like
// `Audio`, `Video`, or `Podcast`.
//
// Your interface must include:
//
// - A property called title to represent the title of the media.
//
// - A function called `play()` to play the media.
//
// Then, create a class called `Audio` that implements the Media interface. The Audio class must use the title property
// in its constructor as well as have an additional property called composer that has String type.
// In the class, implement the `play()` function to print the following: "Playing audio: $title, composed by $composer".
interface Media {
    val title: String
    fun play()
}

class Audio(override val title: String, val composer: String) : Media {
    override fun play() {
        println("Playing audio: $title, composed by $composer")
    }
}

val audio = Audio("Symphony No. 5", "Beethoven")
audio.play()
// Playing audio: Symphony No. 5, composed by Beethoven

println()

// Exercise 3
// You're building a payment processing system for an e-commerce application. Each payment method needs to be able
// to authorize a payment and process a transaction. Some payments also need to be able to process refunds.
//
// 1. In the `Refundable` interface, add a function called `refund()` to process refunds.
// 2. In the PaymentMethod abstract class:
//     - Add a function called `authorize()` that takes an amount and prints a message containing the amount.
//     - Add an abstract function called `processPayment()` that also takes an amount.
// 3. Create a class called `CreditCard` that implements the `Refundable` interface and `PaymentMethod` abstract class.
//    In this class, add implementations for the refund() and processPayment() functions so that they print the
//    following statements:
//
//     - `"Refunding $amount to the credit card."`
//     - `"Processing credit card payment of $amount."`
interface Refundable {
    // Write your code here
   fun refund(amount: Double)
}

abstract class PaymentMethod(val name: String) {
    // Write your code here
    fun authorize(amount: Double) {
        println("Authorizing payment of $$amount.")
    }
    abstract fun processPayment(amount: Double)
}

class CreditCard(name: String) : PaymentMethod(name), Refundable { // Write your code here
    override fun processPayment(amount: Double) {
        println("Processing credit card payment of $$amount.")
    }

    override fun refund(amount: Double) {
        println("Refunding $$amount to the credit card.")
    }
}


val visa = CreditCard("Visa")

visa.authorize(100.0)
// Authorizing payment of $100.0.
visa.processPayment(100.0)
// Processing credit card payment of $100.0.
visa.refund(50.0)
// Refunding $50.0 to the credit card.

println()

// Exercise 4
// You have a simple messaging app that has some basic functionality, but you want to add some functionality for
// smart messages without significantly duplicating your code.
//
// In the code below, define a class called `SmartMessenger` that inherits from the `Messenger` interface but
// delegates the implementation to an instance of the `BasicMessenger` class.
//
// In the `SmartMessenger` class, override the `sendMessage()` function to send smart messages. The function must
// accept a message as an input and return a printed statement: `"Sending a smart message: $message".`
// In addition, call the `sendMessage()` function from the `BasicMessenger` class and prefix the message with `[smart]`.
interface Messenger {
    fun sendMessage(message: String)
    fun receiveMessage(): String
}

class BasicMessenger : Messenger {
    override fun sendMessage(message: String) {
        println("Sending message: $message")
    }

    override fun receiveMessage(): String {
        return "You've got a new message!"
    }
}

class SmartMessenger(val basicMessenger: BasicMessenger): Messenger by basicMessenger { // Write your code here
    override fun sendMessage(message: String) {
        println("Sending a smart message: $message")
        basicMessenger.sendMessage("[smart] $message")
    }
}

val basicMessenger = BasicMessenger()
val smartMessenger = SmartMessenger(basicMessenger)

basicMessenger.sendMessage("Hello!")
// Sending message: Hello!
println(smartMessenger.receiveMessage())
// You've got a new message!
smartMessenger.sendMessage("Hello from SmartMessenger!")
// Sending a smart message: Hello from SmartMessenger!
// Sending message: [smart] Hello from SmartMessenger!