# Tour Objects

Kotlin has three types of object constructs: object declarations, companion objects, and object expressions. All create a single instance of a class.

## Object Declarations

An object declaration defines a class and creates its single instance simultaneously — a singleton. Objects are lazy (created on first access) and thread-safe.

```kotlin
object DoAuth {
    fun takeParams(username: String, password: String) {
        println("input Auth parameters = $username:$password")
    }
}

DoAuth.takeParams("coding_ninja", "N1njaC0ding!")
// input Auth parameters = coding_ninja:N1njaC0ding!
```

Objects cannot have constructors but can inherit from classes and interfaces.

## Data Objects

Add `data` to get auto-generated `toString()` and `equals()`. Unlike data classes, data objects have no `copy()` — there's only one instance to copy from.

```kotlin
data object AppConfig {
    var appName: String = "My Application"
    var version: String = "1.0.0"
}

println(AppConfig)         // AppConfig
println(AppConfig.appName) // My Application
```

## Companion Objects

A class can have one companion object — its properties and functions are shared across all instances and accessed via the class name, not an instance.

```kotlin
class BigBen {
    companion object Bonger {
        fun getBongs(nTimes: Int) {
            repeat(nTimes) { print("BONG ") }
        }
    }
}

BigBen.getBongs(12) // BONG BONG BONG ...
```

The name is optional — if omitted, it defaults to `Companion`. A common use case is factory functions that create instances from alternative inputs:

```kotlin
data class Temperature(val celsius: Double) {
    val fahrenheit: Double = celsius * 9 / 5 + 32

    companion object {
        fun fromFahrenheit(fahrenheit: Double): Temperature =
            Temperature((fahrenheit - 32) * 5 / 9)
    }
}

val temp = Temperature.fromFahrenheit(90.0)
```
