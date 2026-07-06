# Tour Libraries and APIs

Libraries distribute reusable code and expose it through an API — a set of functions, classes, and properties you can use in your code.

## The Standard Library

Most of the standard library (the `kotlin` package) is available without explicit imports. Functions like `println()`, `reversed()`, and collection operations are all included automatically.

Some parts require explicit imports:

```kotlin
import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes

val thirtyMinutes: Duration = 30.minutes
val halfHour: Duration = 0.5.hours
println(thirtyMinutes == halfHour) // true
```

Use `*` to import an entire package. For companion object members (like `.hours`, `.minutes`), import them explicitly — the wildcard won't pick them up.

```kotlin
import kotlin.math.*

fun calculateCompoundInterest(P: Double, r: Double, n: Int, t: Int): Double {
    return P * (1 + r / n).pow(n * t)
}
```

Use `kotlin.time.measureTime { }` to benchmark a block of code:

```kotlin
import kotlin.time.measureTime

val timeTaken = measureTime {
    // code to measure
}
println("Time taken: $timeTaken")
```

## Third-party Libraries

Beyond the standard library, the Kotlin ecosystem has community libraries for things the standard library doesn't cover — for example, `kotlinx-datetime` for cross-platform date/time handling. Find libraries at [klibs.io](https://klibs.io/).

## Opt-In APIs

Some library APIs are marked experimental or unstable — the author requires you to explicitly opt in before using them. You'll see a compiler warning like:

```
This declaration needs opt-in. Its usage should be marked with '@OptIn(...)'
```

Add the annotation at the call site or function level:

```kotlin
@OptIn(ExperimentalStdlibApi::class)
fun myFunction() {
    // use the experimental API here
}
```

This signals you're aware the API may change in future releases.
