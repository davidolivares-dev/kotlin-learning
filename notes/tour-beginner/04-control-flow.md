# Tour Control Flow

Kotlin provides `if` and `when` for conditional logic, and `for` and `while` for loops.

## Conditional Expressions

### If

`if` works as both a statement and an expression. When used as an expression it returns a value, so curly braces are optional for single-line branches:

```kotlin
val a = 1
val b = 2
println(if (a > b) a else b) // 2
```

### When

Use `when` for multiple branches — it's more readable and less error-prone than chained `if/else`. `when` also works as a statement or expression.

```kotlin
val result = when (button) {
    "A" -> "Yes"
    "B" -> "No"
    else -> "Unknown"
}
```

Without a subject, each branch is a full boolean expression — useful when conditions don't share a common value to match against:

```kotlin
val trafficAction = when {
    trafficLightState == "Green" -> "Go"
    trafficLightState == "Yellow" -> "Slow down"
    trafficLightState == "Red" -> "Stop"
    else -> "Malfunction"
}
```

## Ranges

| Syntax              | Equivalent        |
|:--------------------|:------------------|
| `1..4`              | 1, 2, 3, 4        |
| `1..<4`             | 1, 2, 3           |
| `4 downTo 1`        | 4, 3, 2, 1        |
| `1..5 step 2`       | 1, 3, 5           |
| `'a'..'d'`          | a, b, c, d        |

## Loops

### For

Iterate over a range or collection with `for`:

```kotlin
for (number in 1..5) {
    print(number)
}
// 12345

val cakes = listOf("carrot", "cheese", "chocolate")
for (cake in cakes) {
    println("Yummy, it's a $cake cake!")
}
```

### While

`while` checks the condition first; `do-while` executes the block first then checks:

```kotlin
var i = 0
while (i < 3) {
    println(i)
    i++
}

do {
    println(i)
    i--
} while (i > 0)
```

Use `do-while` when the block must run at least once regardless of the condition.
