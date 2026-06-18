# Tour Null Safety

Kotlin catches null-related problems at compile time rather than runtime. By default, no type can hold `null` — you must explicitly opt in with `?`.

## Nullable Types

Add `?` after a type to allow `null`:

```kotlin
var neverNull: String = "hello"
neverNull = null    // compile error

var nullable: String? = "hello"
nullable = null     // ok
```

Passing a nullable type where a non-nullable is expected is also a compile error — the compiler forces you to handle the null case before proceeding.

## Null Checks

The simplest approach: check with `if`:

```kotlin
fun describeString(maybeString: String?): String {
    if (maybeString != null && maybeString.length > 0) {
        return "String of length ${maybeString.length}"
    } else {
        return "Empty or null string"
    }
}
```

## Safe Call Operator `?.`

Access properties or call functions on a nullable value without a null check. Returns `null` if the receiver is `null` instead of throwing:

```kotlin
val nullString: String? = null
println(nullString?.length)     // null
println(nullString?.uppercase()) // null
```

## Elvis Operator `?:`

Provide a fallback value when the left-hand side is `null`:

```kotlin
val nullString: String? = null
println(nullString?.length ?: 0) // 0
```

Chain `?.` and `?:` together to handle multiple nullable steps concisely — a pattern used heavily with scope functions like `let`.
