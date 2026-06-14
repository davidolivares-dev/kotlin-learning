# Tour Classes

Kotlin supports object-oriented programming with classes and objects. Objects are useful for storing 
data in your program. Classes allow you to declare a set of characteristics for an object. When you create 
objects from a class, you can save time and effort because you don't have to declare these characteristics every time.

To declare a class, use the class keyword:

````kotlin
class Customer
````

## Properties

Characteristics of a class's object can be declared in properties. You can declare properties for a class:

- Within parentheses `()` after the class name.

```kotlin
class Contact(val id: Int, var email: String)
```

- Within the class body defined by curly braces `{}`.

```kotlin
class Contact(val id: Int, var email: String) {
    val category: String = ""
}
```

Recommended to declare properties as read-only (`val`) unless they need to be changed after an instance of the
class is created.

Just like with function parameters, class properties can have default values:

```kotlin
class Contact(val id: Int, var email: String = "example@gmail.com") {
    val category: String = "work"
}
```

## Create Instance

To create an object from a class, you declare a class __instance__ using a __constructor__.

By default, Kotlin automatically creates a constructor with the parameters declared in the class header.

For example:

```kotlin
class Contact(val id: Int, var email: String)

fun main() {
    val contact = Contact(1, "mary@gmail.com")
}
```

In the example:

- `Contact` is a class.

- contact is an instance of the `Contact` class.

- `id` and `email` are properties.

- `id` and `email` are used with the default constructor to create `contact`.

Kotlin classes can have many constructors, including ones that you define yourself.

## Access Properties

To access a property of an instance, write the name of the property after the instance name appended with a period `.`:

```kotlin
class Contact(val id: Int, var email: String)

fun main() {
    val contact = Contact(1, "mary@gmail.com")
    
    // Prints the value of the property: email
    println(contact.email)           
    // mary@gmail.com

    // Updates the value of the property: email
    contact.email = "jane@gmail.com"
    
    // Prints the new value of the property: email
    println(contact.email)           
    // jane@gmail.com
}
```

## Member Functions

In addition to declaring properties as part of an object's characteristics, you can also define an 
object's behavior with member functions. In Kotlin, member functions must be declared within the class body. 
To call a member function on an instance, write the function name after the instance name appended with a period `.`.

For example:

```kotlin
class Contact(val id: Int, var email: String) {
    fun printId() {
        println(id)
    }
}

fun main() {
    val contact = Contact(1, "mary@gmail.com")
    // Calls member function printId()
    contact.printId()           
    // 1
}
```

## Data Classes

Kotlin has data classes which are particularly useful for storing data. Data classes have the same functionality
as classes, but they come automatically with additional member functions. These member functions allow you 
to easily print the instance to readable output, compare instances of a class, copy instances, and more. 
As these functions are automatically available, you don't have to spend time writing the same boilerplate code 
for each of your classes.

To declare a data class, use the keyword data:

```kotlin
data class User(val name: String, val id: Int)
```

| Function           | Description                                                                              |
|:-------------------|:-----------------------------------------------------------------------------------------|
| `toString()`       | Prints a readable string of the class instance and its properties.                       |
| `equals()` or `==` | Compares instances of a class.                                                           |
| copy()             | Creates a class instance by copying another, potentially with some different properties. |

### Print as String

To print a readable string of a class instance, you can explicitly call the toString() function, or use print 
functions (println() and print()) which automatically call toString() for you:

```kotlin
val user = User("Alex", 1)

// Automatically uses toString() function so that output is easy to read
println(user)            
// User(name=Alex, id=1)
```

### Compare Instances

To compare data class instances, use the equality operator `==`:

Unlike regular classes where == compares object references, data class == compares the values
of each property (structural equality).

```kotlin
val user = User("Alex", 1)
val secondUser = User("Alex", 1)
val thirdUser = User("Max", 2)

// Compares user to second user
println("user == secondUser: ${user == secondUser}") 
// user == secondUser: true

// Compares user to third user
println("user == thirdUser: ${user == thirdUser}")   
// user == thirdUser: false
```

### Copy Instance

To create an exact copy of a data class instance, call the `copy()` function on the instance.

To create a copy of a data class instance and change some properties, call the `copy()` function on the instance and 
add replacement values for properties as function parameters.

For example:

```kotlin
val user = User("Alex", 1)

// Creates an exact copy of user
println(user.copy())       
// User(name=Alex, id=1)

// Creates a copy of user with name: "Max"
println(user.copy("Max"))  
// User(name=Max, id=1)

// Creates a copy of user with id: 3
println(user.copy(id = 3)) 
// User(name=Alex, id=3)
```

