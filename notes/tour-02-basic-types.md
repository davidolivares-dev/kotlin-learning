# Tour Basic Types

## In Kotlin

- every variable and data structure has a type
- types tell compiler what you are allowed to do with the variable or ds

## Basic Types

`Kotlin` has the following basic types

| Category               | Basic Types                        | Example Code                                                  |
|:-----------------------|:-----------------------------------|:--------------------------------------------------------------|
| Integers               | `Byte`, `Short`, `Int`, `Long`     | `val year: Int = 2020`                                        |
| Unsigned Integers      | `UByte`, `UShort`, `UInt`, `ULong` | `val score: UInt = 100u`                                      |
| Floating-point numbers | `Float`, `Double`                  | `val currentTemp: Float = 24.5f`, `val price: Double = 19.99` |
| Booleans               | `Boolean`                          | `val isEnabled: Boolean = true`                               |
| Characters             | `Char`                             | `val separator: Char = ','`                                   |
| Strings                | `String`                           | `val message: String = "Hello, world!"`                       |

To declare a variable without initializing it, specify its type with `:`.

```kotlin
// Variable declared without initialization
val d: Int
// Variable initialized
d = 3

// Variable explicitly typed and initialized
val e: String = "hello"

// Variables can be read because they have been initialized
println(d) // 3
println(e) // hello
```

If you don't initialize a variable before it is read, you see an error:

```kotlin
// Variable declared without initialization
val d: Int

// Triggers an error
println(d)
// Variable 'd' must be initialized
```

## Key Concepts

- Int overflow – Int is 32-bit: max value is ~2.1 billion. Long is
   64-bit, max ~9.2 quintillion. `100_000_000_000_000` is 100 trillion — way over Int. In
   Kotlin this is actually a compile error, not a runtime exception — the literal itself is too large to fit in an Int
- Float vs Double – Double is 64-bit (~15-17 significant decimal digits). Float is 32-bit (~6-7
   digits). In practice, you use Double unless you have a specific reason to save memory (e.g. large arrays in graphics/game code).
- Explicit vs implicit – Leave the type implicit when it's obvious from the right-hand side (val name = "David" — clearly a
   String, no need to spell it out). Write it explicitly when the inferred type isn't obvious at a glance, when you want to widen the type (e.g. force Long instead of Int), or at public
   API boundaries where the type serves as documentation.