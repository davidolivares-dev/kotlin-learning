# Tour Properties

Kotlin properties are more powerful than simple fields — they support custom accessors, delegation, lazy initialization, and extension.

## Backing Fields

When you define a custom getter or setter, use `field` to refer to the stored value. Referencing the property itself inside its own setter causes infinite recursion.

```kotlin
class Person {
    var name: String = ""
        set(value) { field = value.replaceFirstChar { it.uppercase() } }
}

val person = Person()
person.name = "kodee"
println(person.name) // Kodee
```

Backing fields exist automatically when you use default accessors or reference `field` explicitly. Extension properties have no backing field — they must compute their value directly.

## Extension Properties

Add computed properties to existing classes without modifying them. No state can be stored — only `get()` (and optionally `set()`) is allowed.

```kotlin
data class Person(val firstName: String, val lastName: String)

val Person.fullName: String
    get() = "$firstName $lastName"

println(Person("John", "Doe").fullName) // John Doe
```

```kotlin
val Double.asMiles: Double
    get() = this * 0.621371
```

## Delegated Properties

Use `by` to delegate a property's get/set to another object. Useful for caching, logging, or mapping to external storage.

```kotlin
class CachedStringDelegate {
    var cachedValue: String? = null

    operator fun getValue(thisRef: User, property: Any?): String {
        if (cachedValue == null) {
            cachedValue = "${thisRef.firstName} ${thisRef.lastName}"
            println("Computed and cached: $cachedValue")
        } else {
            println("Accessed from cache: $cachedValue")
        }
        return cachedValue ?: "Unknown"
    }
}

class User(val firstName: String, val lastName: String) {
    val displayName: String by CachedStringDelegate()
}
```

The delegate must implement `getValue()` (and `setValue()` for `var`). Parameters are the containing object and the property metadata.

## Lazy Properties

Initialize a property only when it's first accessed using `by lazy { }`. The block runs once and the result is cached for all subsequent accesses. Thread-safe by default.

```kotlin
val databaseConnection: Database by lazy {
    val db = Database()
    db.connect()
    db
}
```

Use when initialization is expensive and the property may not always be needed.

## Observable Properties

Use `Delegates.observable()` to run a callback whenever a property changes. The lambda receives the property, the old value, and the new value.

```kotlin
import kotlin.properties.Delegates.observable

class Thermostat {
    var temperature: Double by observable(20.0) { _, old, new ->
        if (new > 25) {
            println("Warning: Too high! ($old°C -> $new°C)")
        } else {
            println("Temperature updated: $old°C -> $new°C")
        }
    }
}
```

Useful for logging, UI updates, and validation without coupling the property logic to external observers.
