# Tour Basic Types

Every variable and data structure in Kotlin has a type. Types tell the compiler what operations are valid on a value.

## Basic Types

| Category               | Basic Types                        | Example Code                                                  |
|:-----------------------|:-----------------------------------|:--------------------------------------------------------------|
| Integers               | `Byte`, `Short`, `Int`, `Long`     | `val year: Int = 2020`                                        |
| Unsigned Integers      | `UByte`, `UShort`, `UInt`, `ULong` | `val score: UInt = 100u`                                      |
| Floating-point numbers | `Float`, `Double`                  | `val currentTemp: Float = 24.5f`, `val price: Double = 19.99` |
| Booleans               | `Boolean`                          | `val isEnabled: Boolean = true`                               |
| Characters             | `Char`                             | `val separator: Char = ','`                                   |
| Strings                | `String`                           | `val message: String = "Hello, world!"`                       |

You can declare a variable without initializing it as long as you initialize it before reading:

```kotlin
val d: Int
d = 3
println(d) // 3
```

```kotlin
val d: Int
println(d) // Error: Variable 'd' must be initialized
```

## Key Concepts

- **Int overflow** — `Int` is 32-bit (~2.1 billion max). Oversized literals like `100_000_000_000_000` are a compile error in Kotlin, not a runtime exception. Use `Long` for large values (64-bit, ~9.2 quintillion max).
- **Float vs Double** — `Double` is 64-bit (~15–17 significant digits) and is the default. Use `Float` (32-bit, ~6–7 digits) only when memory matters, e.g. large arrays in graphics code.
- **Explicit vs implicit typing** — omit the type when it's obvious from the right-hand side (`val name = "David"`). Write it explicitly when widening a type (e.g. forcing `Long` instead of `Int`) or at public API boundaries where it serves as documentation.
