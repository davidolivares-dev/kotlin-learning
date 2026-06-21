# Tour Lambda Expressions with Receiver

A lambda with receiver is a lambda that has access to the members of a receiver object without needing to reference it explicitly — the same way an extension function works, but as a lambda.

## Syntax

```
ReceiverType.(ParameterTypes) -> ReturnType
```

For example, `MutableList<Int>.() -> Unit` is a lambda with `MutableList<Int>` as the receiver, no parameters, and no return value.

## How It Works

When a function accepts a lambda with receiver, it invokes the lambda on an instance of that type. Inside the lambda, `this` refers to that instance and its members are in scope directly:

```kotlin
class Canvas {
    fun drawCircle() = println("Drawing a circle")
    fun drawSquare() = println("Drawing a square")
}

fun render(block: Canvas.() -> Unit): Canvas {
    val canvas = Canvas()
    canvas.block()
    return canvas
}

render {
    drawCircle()  // this.drawCircle() — receiver is Canvas
    drawSquare()
}
```

The `render()` function creates a `Canvas`, then calls `block()` on it. Inside the trailing lambda, `drawCircle()` and `drawSquare()` are called directly because the receiver is `Canvas`.

## DSLs and Builders

Lambdas with receivers are the foundation of Kotlin DSLs and type-safe builders. The pattern: a function creates an object, applies a lambda with receiver to configure it, then returns it.

```kotlin
fun menu(name: String, init: Menu.() -> Unit): Menu {
    val menu = Menu(name)
    menu.init()
    return menu
}

val mainMenu = menu("Main Menu") {
    item("Home")
    item("Settings")
    item("Exit")
}
```

The standard library uses this pattern in `buildList { }` and `buildString { }`:

```kotlin
fun List<Int>.incremented(): List<Int> {
    val original = this
    return buildList {
        for (n in original) add(n + 1)
    }
}
```

Inside `buildList { }`, the receiver is a `MutableList`, so `add()` is available directly.
