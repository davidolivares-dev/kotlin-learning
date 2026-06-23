# Tour Open and Special Classes

By default, Kotlin classes are final — they cannot be inherited. This chapter covers how to opt into inheritance and several special class types designed for specific use cases.

## Open Classes

Mark a class with `open` to allow inheritance. Member functions and properties must also be marked `open` to allow overriding.

```kotlin
open class Vehicle(val make: String, val model: String) {
    open fun displayInfo() {
        println("Vehicle Info: Make - $make, Model - $model")
    }
}

class Car(make: String, model: String, val numberOfDoors: Int) : Vehicle(make, model) {
    override fun displayInfo() {
        println("Car Info: Make - $make, Model - $model, Doors - $numberOfDoors")
    }
}
```

When inheriting, the child class must initialize all parent constructor parameters. The parent class is listed before any interfaces in the declaration.

For overriding properties, prefer passing values through the constructor over `override val` — it's cleaner:

```kotlin
// preferred
open class Vehicle(val make: String, val model: String, val transmissionType: String = "Manual")
class Car(make: String, model: String, numberOfDoors: Int) : Vehicle(make, model, "Automatic")
```

## Sealed Classes

A sealed class restricts its subclasses to the same package. This makes `when` expressions exhaustive — the compiler knows every possible subtype, so no `else` branch is needed.

```kotlin
sealed class DeliveryStatus {
    data class Pending(val sender: String) : DeliveryStatus()
    data class InTransit(val estimatedDeliveryDate: String) : DeliveryStatus()
    data class Delivered(val deliveryDate: String, val recipient: String) : DeliveryStatus()
    data class Canceled(val reason: String) : DeliveryStatus()
}

fun printDeliveryStatus(status: DeliveryStatus) {
    when (status) {
        is DeliveryStatus.Pending -> println("Pending pickup from ${status.sender}.")
        is DeliveryStatus.InTransit -> println("Arriving by ${status.estimatedDeliveryDate}.")
        is DeliveryStatus.Delivered -> println("Delivered to ${status.recipient}.")
        is DeliveryStatus.Canceled -> println("Canceled: ${status.reason}.")
    }
}
```

Subclasses can be data classes, data objects, or regular classes — mix as needed.

## Enum Classes

Enum classes represent a fixed set of constant values. Each constant is a singleton instance of the enum class.

```kotlin
enum class State {
    IDLE, RUNNING, FINISHED
}

val message = when (State.RUNNING) {
    State.IDLE -> "It's idle"
    State.RUNNING -> "It's running"
    State.FINISHED -> "It's finished"
}
```

Enums can have properties and member functions. Separate the constants from member functions with a semicolon:

```kotlin
enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF), YELLOW(0xFFFF00);

    fun containsRed() = (this.rgb and 0xFF0000 != 0)
}

println(Color.RED.containsRed())    // true
println(Color.BLUE.containsRed())   // false
println(Color.YELLOW.containsRed()) // true
```

## Inline Value Classes

Wrap a single value in a type-safe class without the runtime overhead of object allocation. Requires `@JvmInline` and exactly one property in the header.

```kotlin
@JvmInline
value class Email(val address: String)

fun sendEmail(email: Email) {
    println("Sending email to ${email.address}")
}
```

At runtime, the wrapper is optimized away — the compiler uses the underlying value directly. Useful for adding type safety without performance cost (e.g. distinguishing `Email` from `Username` when both are `String`).

## Summary

| Class Type   | Key Feature                                          |
|:-------------|:-----------------------------------------------------|
| `open`       | Opts into inheritance; members also need `open`      |
| `sealed`     | Restricts subclasses to same package; exhaustive `when` |
| `enum`       | Fixed set of constants; can have properties and functions |
| `value`      | Single-property wrapper; zero runtime overhead       |
