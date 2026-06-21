# Tour Classes and Interfaces

Kotlin provides abstract classes and interfaces to share behavior across classes. Both cannot be instantiated directly.

## Abstract Classes

Use `abstract` to declare a class that other classes can inherit from. Abstract classes can have both concrete (implemented) and abstract (unimplemented) members. Child classes use `override` to implement abstract members.

```kotlin
abstract class Product(val name: String, var price: Double) {
    abstract val category: String

    fun productInfo(): String {
        return "Product: $name, Category: $category, Price: $price"
    }
}

class Electronic(name: String, price: Double, val warranty: Int) : Product(name, price) {
    override val category = "Electronic"
}
```

By default, Kotlin classes cannot be inherited — `abstract` classes are the exception.

## Interfaces

Interfaces define a contract that classes can implement. Unlike abstract classes:

- No constructor or header
- Members are implicitly open (inheritable by default)
- A class can implement multiple interfaces

```kotlin
interface PaymentMethod {
    fun initiatePayment(amount: Double): String
}

interface PaymentType {
    val paymentType: String
}

class CreditCardPayment(val cardNumber: String) : PaymentMethod, PaymentType {
    override fun initiatePayment(amount: Double) =
        "Payment of $$amount via card ending in ${cardNumber.takeLast(4)}."
    override val paymentType: String = "Credit Card"
}
```

## Abstract Class vs Interface

| Feature          | Abstract Class                  | Interface                          |
|:-----------------|:--------------------------------|:-----------------------------------|
| Constructor      | Has one                         | None                               |
| Instantiation    | Cannot instantiate              | Cannot instantiate                 |
| Inheritance      | Single parent only              | Multiple interfaces allowed        |
| Concrete members | Yes                             | Yes (implicitly open)              |
| Use case         | Share code in a class hierarchy | Define capabilities/contracts      |

## Delegation

When a class implements an interface with many members, use the `by` keyword to delegate the implementation to another object. Only override what you need to change:

```kotlin
class SmartMessenger(val basic: BasicMessenger) : Messenger by basic {
    override fun sendMessage(message: String) {
        println("Sending a smart message: $message")
        basic.sendMessage("[smart] $message")
    }
}
```

`receiveMessage()` and any other `Messenger` members are automatically delegated to `basic` — no boilerplate needed.
