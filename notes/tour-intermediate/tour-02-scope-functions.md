# Scope Functions

In programming, a scope is the area in which your variable or object is recognized. The most commonly referred 
to scopes are the global scope and the local scope:

- __Global Scope__ - a variable or object that is accessible from anywhere in the program
- __Local Scope__ - a variable or object that is only accessible within the block of function where it is defined.

In Kotlin, there are also scope functions that allow you to create a temporary scope around an object 
and execute some code.

Scope functions make your code more concise because you don't have to refer to the name of your object within
the temporary scope. Depending on the scope function, you can access the object either by referencing it via the
keyword `this` or using it as an argument via the keyword `it`.

Kotlin has five scope functions in total: `let`, `apply`, `run`, `also`, and `with`.

Each scope function takes a lambda expression and returns either the object or the result of the lambda expression.

## Let

Use `let` to perform null checks and use the result later. Instead of an `if/else` null check:

```kotlin
val confirm = if (address != null) sendNotification(address) else null
```

You can use a safe call with `let`:

```kotlin
val confirm = address?.let {
    sendNotification(it)
}
```

The `address` variable is accessed via `it` inside the temporary scope. If `address` is null, the block is skipped entirely.

## Apply

Use `apply` to initialize an object at the time of creation. Instead of configuring an instance across multiple lines later:

```kotlin
val client = Client()
client.token = "asdf"
client.connect()
client.authenticate()
```

Group it all at creation time:

```kotlin
val client = Client().apply {
    token = "asdf"
    connect()
    authenticate()
}
```

Inside the block, `this` refers to the instance so you don't need to prefix each call with `client.`. `apply` returns the object itself.

## Run

Similar to `apply`, but use `run` when you want to initialize an object AND immediately compute a result:

```kotlin
val result: String = client.run {
    connect()
    authenticate()
    getData()
}
```

The last expression in the block is returned as the result.

## Also

Use `also` to perform a side effect action (like logging) on an object and then continue using the object unchanged. It's useful for inserting logging into a chain without breaking it:

```kotlin
medals
    .map { it.uppercase() }
    .also { println(it) }   // logs after map
    .filter { it.length > 4 }
    .also { println(it) }   // logs after filter
    .reversed()
```

`also` returns the object itself, so the chain continues uninterrupted.

## With

Unlike the other scope functions, `with` is not an extension function — you pass the object as an argument. Use it when you need to call multiple functions on the same object and don't want to repeat its name:

```kotlin
with(canvas) {
    text(10, 10, "Foo")
    rect(20, 30, 100, 50)
    circ(40, 60, 25)
}
```

Inside the block, `this` refers to `canvas`.

## Quick Reference

| Function | Access via | Returns       | Use case                                                |
|:---------|:-----------|:--------------|:--------------------------------------------------------|
| `let`    | `it`       | Lambda result | Null checks; use the returned object later              |
| `apply`  | `this`     | The object    | Initialize an object at creation time                   |
| `run`    | `this`     | Lambda result | Initialize an object AND compute a result               |
| `also`   | `it`       | The object    | Side effects (logging, debugging) without breaking flow |
| `with`   | `this`     | Lambda result | Call multiple functions on an object                    |
