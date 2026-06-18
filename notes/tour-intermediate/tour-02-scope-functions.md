# Tour Scope Functions

Scope functions create a temporary scope around an object so you can access its properties and functions without repeating its name. Kotlin has five: `let`, `apply`, `run`, `also`, and `with`. Each takes a lambda and returns either the object or the lambda result.

Inside the lambda, the object is accessed via `this` (treated as the receiver) or `it` (passed as an argument), depending on the function.

## Let

Use `let` to perform null checks and use the result later. Instead of an `if/else` null check:

```kotlin
val confirm = if (address != null) sendNotification(address) else null
```

Use a safe call with `let`:

```kotlin
val confirm = address?.let {
    sendNotification(it)
}
```

The object is accessed via `it`. If `address` is null the block is skipped entirely.

## Apply

Use `apply` to initialize an object at creation time. Instead of configuring an instance across multiple lines:

```kotlin
val client = Client()
client.token = "asdf"
client.connect()
client.authenticate()
```

Group it at creation:

```kotlin
val client = Client().apply {
    token = "asdf"
    connect()
    authenticate()
}
```

The object is accessed via `this` inside the block. `apply` returns the object itself.

## Run

Similar to `apply`, but use `run` when you want to initialize an object and immediately compute a result:

```kotlin
val result: String = client.run {
    connect()
    authenticate()
    getData()
}
```

The last expression in the block is returned as the result.

## Also

Use `also` to perform a side-effect action (like logging) and then continue using the object unchanged. Useful for inserting logging into a chain without breaking it:

```kotlin
medals
    .map { it.uppercase() }
    .also { println(it) }    // logs after map
    .filter { it.length > 4 }
    .also { println(it) }    // logs after filter
    .reversed()
```

The object is accessed via `it`. `also` returns the object itself so the chain continues uninterrupted.

## With

Unlike the other scope functions, `with` is not an extension function — the object is passed as an argument. Use it when calling multiple functions on the same object to avoid repeating its name:

```kotlin
with(canvas) {
    text(10, 10, "Foo")
    rect(20, 30, 100, 50)
    circ(40, 60, 25)
}
```

The object is accessed via `this` inside the block.

## Quick Reference

| Function | Access via | Returns       | Use case                                                |
|:---------|:-----------|:--------------|:--------------------------------------------------------|
| `let`    | `it`       | Lambda result | Null checks; use the returned object later              |
| `apply`  | `this`     | The object    | Initialize an object at creation time                   |
| `run`    | `this`     | Lambda result | Initialize an object AND compute a result               |
| `also`   | `it`       | The object    | Side effects (logging, debugging) without breaking flow |
| `with`   | `this`     | Lambda result | Call multiple functions on an object                    |
