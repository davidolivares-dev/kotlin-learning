# Tour Null Safety (Intermediate)

This chapter builds on beginner null safety with type casting, null-aware collection functions, and idiomatic patterns for cleaner null handling.

## Type Checking and Smart Casts

Use `is` and `!is` to check an object's type. Inside a branch where the check passes, Kotlin automatically smart-casts the variable — no explicit cast needed.

```kotlin
fun printObjectType(obj: Any) {
    when (obj) {
        is Int -> println("It's an Integer with value $obj")
        !is Double -> println("It's NOT a Double")
        else -> println("Unknown type")
    }
}
```

## Safe vs Unsafe Casts

`as` casts explicitly but throws at runtime if the cast fails. `as?` returns `null` instead:

```kotlin
val a: String? = null
val b = a as String   // runtime crash
val c = a as? String  // null — safe
```

Combine `as?` with `?:` for concise fallback logic:

```kotlin
fun calculateTotalStringLength(items: List<Any>): Int {
    return items.sumOf { (it as? String)?.length ?: 0 }
}
```

## Null-aware Collection Functions

| Function              | What it does                                                       |
|:----------------------|:-------------------------------------------------------------------|
| `filterNotNull()`     | Removes null values from a list                                    |
| `listOfNotNull()`     | Builds a list, skipping any null arguments                         |
| `mapNotNull()`        | Maps a list and filters out null results                           |
| `singleOrNull()`      | Returns the single matching element, or null if none/multiple match |
| `firstNotNullOfOrNull()` | Returns the first non-null result of a transform             |
| `maxOrNull()` / `minOrNull()` | Returns max/min, or null if collection is empty         |
| `reduceOrNull()`      | Accumulates values; returns null if collection is empty            |

```kotlin
val emails: List<String?> = listOf("alice@example.com", null, "bob@example.com")
println(emails.filterNotNull()) // [alice@example.com, bob@example.com]

users.mapNotNull { user ->
    user.username.takeIf { user.isActive }
}
```

## Early Returns with Elvis

Combining early returns with `?:` keeps functions flat and readable — no nested null checks:

```kotlin
fun getNumberOfFriends(users: Map<Int, User>, userId: Int): Int {
    val user = users[userId] ?: return -1
    return user.friends.size
}
```

The same logic can be written as a chain, but early returns are often easier to read when there are multiple null checks:

```kotlin
fun validateStock(requested: Int?, available: Int?): Int {
    val validRequested = requested ?: return -1
    val validAvailable = available ?: return -1
    if (validRequested < 0) return -1
    if (validRequested > validAvailable) return -1
    return validRequested
}
```
