# Tour Null Safety

In Kotlin, it's possible to have a `null` value. Kotlin uses null values when something is missing or not yet set. 

To help prevent issues with `null` values in your programs, Kotlin has null safety in place. Null safety detects 
potential problems with `null` values at compile time, rather than at run time.

Null safety is a combination of features that allow you to:

- Explicitly declare when `null` values are allowed in your program.

- Check for `null` values.

- Use safe calls to properties or functions that may contain `null` values.

- Declare actions to take if `null` values are detected.

## Nullable Types

Kotlin supports nullable types which allows the possibility for the declared type to have `null` values. 
By default, a type is not allowed to accept `null` values. Nullable types are declared by explicitly 
adding `?` after the type declaration.

```kotlin
fun main() {
    // neverNull has String type
    var neverNull: String = "This can't be null"

    // Throws a compiler error
    neverNull = null

    // nullable has nullable String type
    var nullable: String? = "You can keep a null here"

    // This is OK
    nullable = null

    // By default, null values aren't accepted
    var inferredNonNull = "The compiler assumes non-nullable"

    // Throws a compiler error
    inferredNonNull = null

    // notNull doesn't accept null values
    fun strLength(notNull: String): Int {                 
        return notNull.length
    }

    println(strLength(neverNull)) // 18
    println(strLength(nullable))  // Throws a compiler error
}
```

## Check For Null Values

You can check for the presence of `null` values within conditional expressions. In the following example, 
the `describeString()` function has an `if` statement that checks whether `maybeString` is not `null` and if 
its `length` is greater than zero:

```kotlin
fun describeString(maybeString: String?): String {
    if (maybeString != null && maybeString.length > 0) {
        return "String of length ${maybeString.length}"
    } else {
        return "Empty or null string"
    }
}

fun main() {
    val nullString: String? = null
    println(describeString(nullString))
    // Empty or null string
}
```

## Use Safe Calls

To safely access properties of an object that might contain a null value, use the safe call operator `?.`.
The safe call operator returns `null` if either the object or one of its accessed properties is `null`.
This is useful if you want to avoid the presence of null values triggering errors in your code.

In the following example, the `lengthString()` function uses a safe call to return either the length of the 
string or `null`:

```kotlin
fun lengthString(maybeString: String?): Int? = maybeString?.length

fun main() { 
    val nullString: String? = null
    println(lengthString(nullString))
    // null
}
```

The safe call operator can also be used to safely call an extension or member function. In this case, a null check 
is performed before the function is called. If the check detects a `null` value, then the call is skipped and `null` 
is returned.

In the following example, `nullString` is `null` so the invocation of `.uppercase()` is skipped and `null` is returned:

```kotlin
fun main() {
    val nullString: String? = null
    println(nullString?.uppercase())
    // null
}
```

## Use Elvis Operator

You can provide a default value to return if a `null` value is detected by using the Elvis operator `?:`.

Write on the left-hand side of the Elvis operator what should be checked for a `null` value. 
Write on the right-hand side of the Elvis operator what should be returned if a `null` value is detected.

In the following example, `nullString` is `null` so the safe call to access the `length` property returns a null value. 
As a result, the Elvis operator returns `0`:

```kotlin
fun main() {
    val nullString: String? = null
    println(nullString?.length ?: 0)
    // 0
}
```



