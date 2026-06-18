# Tour Hello World

In Kotlin, programs start in the `main()` function. In `.kts` script files `main()` is unnecessary — code runs top-to-bottom like a script.

## Functions

Declare functions with the `fun` keyword. `println()` and `print()` are top-level functions — unlike Java, Kotlin lets you define functions outside of any class.

```kotlin
fun hello() {
    println("Hello, world!")
}

hello()
// Hello, world!
```

## Variables

- `val` — read-only reference (preferred). Only the reference is immutable; a `val` pointing to a mutable object can still have that object modified.
- `var` — reassignable. Only use when you genuinely need to reassign.

```kotlin
val name = "Mary"   // immutable reference
var age = 20        // reassignable
age = 21            // ok
```

## String Templates

Use `$variable` to embed a value in a string, or `${expression}` to evaluate an expression inline.

```kotlin
val name = "Mary"
val age = 20
println("$name is $age years old")         // Mary is 20 years old
println("Next year she'll be ${age + 1}")  // Next year she'll be 21
```
