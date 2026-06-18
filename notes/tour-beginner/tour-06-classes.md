# Tour Classes

Classes let you define a blueprint for objects. Declare a class with the `class` keyword:

```kotlin
class Customer
```

## Properties

Declare properties in the class header (constructor parameters) or in the class body. Header properties are passed in at creation; body properties are internal and not part of the constructor.

```kotlin
class Contact(val id: Int, var email: String) {
    val category: String = "work"   // body property — not in constructor
}
```

Prefer `val` for properties unless they need to change after the instance is created. Properties can have default values just like function parameters.

## Create Instance

Kotlin auto-generates a constructor from the class header. No `new` keyword needed:

```kotlin
val contact = Contact(1, "mary@gmail.com")
```

## Access Properties

Access and update properties with dot notation:

```kotlin
println(contact.email)          // mary@gmail.com
contact.email = "jane@gmail.com"
println(contact.email)          // jane@gmail.com
```

## Member Functions

Define behavior inside the class body. Call them with dot notation on an instance:

```kotlin
class Contact(val id: Int, var email: String) {
    fun printId() {
        println(id)
    }
}

contact.printId() // 1
```

## Data Classes

Use `data class` when the purpose of a class is to hold data. The compiler auto-generates `toString()`, `equals()`/`==`, and `copy()`.

```kotlin
data class User(val name: String, val id: Int)
```

| Function           | Description                                                              |
|:-------------------|:-------------------------------------------------------------------------|
| `toString()`       | Returns a readable string of the instance and its properties.            |
| `equals()` or `==` | Compares property values (structural equality).                          |
| `copy()`           | Creates a new instance copying the original, with optional overrides.    |

### Structural Equality

Unlike regular classes where `==` compares object references, data class `==` compares the values of each property:

```kotlin
val user = User("Alex", 1)
val secondUser = User("Alex", 1)
println(user == secondUser) // true — same property values
```

### Copy

`copy()` is especially useful with `val` properties — since you can't reassign them, `copy()` lets you create a modified version without reconstructing the whole object:

```kotlin
val user = User("Alex", 1)
println(user.copy(name = "Max")) // User(name=Max, id=1)
println(user.copy(id = 3))       // User(name=Alex, id=3)
```
