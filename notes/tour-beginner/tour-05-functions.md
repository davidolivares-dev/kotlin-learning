# Tour Functions

Declare functions with `fun`. Parameters require explicit types; the return type follows the parentheses separated by `:`.

```kotlin
fun sum(x: Int, y: Int): Int {
    return x + y
}
```

## Named Arguments

Pass arguments by name to improve readability and write them in any order:

```kotlin
fun printMessageWithPrefix(message: String, prefix: String) {
    println("[$prefix] $message")
}

printMessageWithPrefix(prefix = "Log", message = "Hello")
// [Log] Hello
```

## Default Parameters

Parameters can have defaults, making them optional at the call site:

```kotlin
fun printMessageWithPrefix(message: String, prefix: String = "Info") {
    println("[$prefix] $message")
}

printMessageWithPrefix("Hello")           // [Info] Hello
printMessageWithPrefix("Hello", "Log")    // [Log] Hello
```

## Unit

Functions that don't return a meaningful value have return type `Unit`. You don't need to declare it or write `return`:

```kotlin
fun printMessage(message: String) {
    println(message)
}
```

## Single-expression Functions

When the function body is a single expression, replace the block body with `=`. The return type can be omitted since Kotlin infers it:

```kotlin
fun sum(x: Int, y: Int) = x + y
```

With block-body functions (`{ return ... }`), the return type is required — the compiler won't infer it.

## Lambda Expressions

Lambdas are anonymous functions written inside `{ }`. Parameters come before `->`, body after:

```kotlin
val upperCaseString = { text: String -> text.uppercase() }
println(upperCaseString("hello")) // HELLO
```

### Function Types

A function type describes a lambda's signature: `(ParameterTypes) -> ReturnType`. Use it when explicitly typing a lambda variable or declaring a function parameter that accepts a lambda:

```kotlin
val upperCaseString: (String) -> String = { text -> text.uppercase() }
```

### Pass to Another Function

Common with collection operations like `.filter()` and `.map()`:

```kotlin
val numbers = listOf(1, -2, 3, -4, 5, -6)
val positives = numbers.filter { x -> x > 0 }  // [1, 3, 5]
val doubled = numbers.map { x -> x * 2 }        // [2, -4, 6, -8, 10, -12]
```

### Return From a Function

A function can return a lambda — declare the function type so the compiler knows what's coming back:

```kotlin
fun toSeconds(time: String): (Int) -> Int = when (time) {
    "hour"   -> { value -> value * 3600 }
    "minute" -> { value -> value * 60 }
    else     -> { value -> value }
}
```

### Trailing Lambdas

If a lambda is the last (or only) parameter, it can move outside the parentheses:

```kotlin
println(listOf(1, 2, 3).fold(0) { x, item -> x + item }) // 6
```
