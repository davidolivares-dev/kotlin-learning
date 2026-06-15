# Tour Functions

You can declare your own functions in Kotlin using the `fun` keyword.

```kotlin
fun hello() {
    return println("Hello, world!")
}

fun main() {
    hello()
    // Hello, world!
}
```

In Kotlin:

- Function parameters are written within parentheses `()`.
- Each parameter must have a type, and multiple parameters must be separated by commas `,`.
- The return type is written after the function's parentheses `()`, separated by a colon `:`.
- The body of a function is written within curly braces `{}`.
- The `return` keyword is used to exit or return something from a function. 
- If a function doesn't return anything useful, the return type and return keyword can be omitted.

In the following example:

- `x` and `y` are function parameters.

- `x` and `y` have type `Int`.

- The function's return type is `Int`.

- The function returns a sum of `x` and `y` when called.

```kotlin
fun sum(x: Int, y: Int): Int {
    return x + y
}

fun main() {
    println(sum(1, 2))
    // 3
}
```

## Named Arguments

For concise code, when calling your function, you don't have to include parameter names. However, including parameter 
names does make your code easier to read. This is called using named arguments. If you do include parameter names, 
then you can write the parameters in any order.

```kotlin
fun printMessageWithPrefix(message: String, prefix: String) {
    println("[$prefix] $message")
}

fun main() {
    // Uses named arguments with swapped parameter order
    printMessageWithPrefix(prefix = "Log", message = "Hello")
    // [Log] Hello
}
```

## Default Parameters

ou can define default values for your function parameters. Any parameter with a default value can be omitted when 
calling your function. To declare a default value, use the assignment operator `=` after the type:

```kotlin
fun printMessageWithPrefix(message: String, prefix: String = "Info") {
    println("[$prefix] $message")
}

fun main() {
    // Function called with both parameters
    printMessageWithPrefix("Hello", "Log") 
    // [Log] Hello
    
    // Function called only with message parameter
    printMessageWithPrefix("Hello")        
    // [Info] Hello
    
    printMessageWithPrefix(prefix = "Log", message = "Hello")
    // [Log] Hello
}
```

## Functions Without Return

If your function doesn't return a useful value then its return type is `Unit`. 
`Unit` is a type with only one value – `Unit`. You don't have to declare that `Unit` is returned explicitly 
in your function body. 

```kotlin
fun printMessage(message: String) {
    println(message)
    // `return Unit` or `return` is optional
}

fun main() {
    printMessage("Hello")
    // Hello
}
```

## Single-expression Functions

To make your code more concise, you can use single-expression functions. 
For example, the `sum()` function can be shortened:

```kotlin
fun sum(x: Int, y: Int): Int {
    return x + y
}

fun main() {
    println(sum(1, 2))
    // 3
}
```

You can remove the curly braces `{}` and declare the function body using the assignment operator `=`. 
When you use the assignment operator `=`, Kotlin uses type inference, so you can also omit the return type. 
The `sum()` function then becomes one line:

```kotlin
fun sum(x: Int, y: Int) = x + y

fun main() {
    println(sum(1, 2))
    // 3
}
```

However, if you want your code to be quickly understood by other developers, 
it's a good idea to explicitly define the return type even when using the assignment operator `=`. 

With block-body functions, the return type isn't optional

*To stop the code in your function from being processed further than a certain point, use the return keyword.

## Lambda Expressions

Kotlin allows you to write even more concise code for functions by using lambda expressions.

For example, the following uppercaseString() function:

```kotlin
fun uppercaseString(text: String): String {
    return text.uppercase()
}
fun main() {
    println(uppercaseString("hello"))
    // HELLO
}
```

Can also be written as a lambda expression:

```kotlin
fun main() {
    val upperCaseString = { text: String -> text.uppercase() }
    println(upperCaseString("hello"))
    // HELLO
}
```

Lambda expressions can be hard to understand at first glance so let's break it down. 
Lambda expressions are written within curly braces `{}`.

Within the lambda expression, you write:

- The parameters followed by an `->`.

- The function body after the `->`.

Lambda expressions can be used in a number of ways. You can:

- Pass a lambda expression as a parameter to another function

- Return a lambda expression from a function

- Invoke a lambda expression on its own

### Pass to Another Function

great example of when it is useful to pass a lambda expression to a function, is using the 
`.filter()` function on collections:

```kotlin
val numbers = listOf(1, -2, 3, -4, 5, -6)

val positives = numbers.filter ({ x -> x > 0 })

val isNegative = { x: Int -> x < 0 }
val negatives = numbers.filter(isNegative)

println(positives)
// [1, 3, 5]
println(negatives)
// [-2, -4, -6]
```

The .filter() function accepts a lambda expression as a predicate and applies it to each element of the list. 
The function keeps an element only if the predicate returns true:

- `{ x -> x > 0 }` returns true if the element is positive.

- `{ x -> x < 0 }` returns true if the element is negative.

This example demonstrates two ways of passing a lambda expression to a function:

- For positive numbers, the example adds the lambda expression directly in the .filter() function.

- For negative numbers, the example assigns the lambda expression to the isNegative variable. 
  Then the isNegative variable is used as a function parameter in the `.filter()` function. 
  In this case, you have to specify the type of function parameters `(x)` in the lambda expression.

Another good example, is using the `.map()` function to transform items in a collection:

```kotlin
val numbers = listOf(1, -2, 3, -4, 5, -6)
val doubled = numbers.map { x -> x * 2 }

val isTripled = { x: Int -> x * 3 }
val tripled = numbers.map(isTripled)

println(doubled)
// [2, -4, 6, -8, 10, -12]
println(tripled)
// [3, -6, 9, -12, 15, -18]
```

The `.map()` function accepts a lambda expression as a transform function:

- `{ x -> x * 2 }` takes each element of the list and returns that element multiplied by 2.

- `{ x -> x * 3 }` takes each element of the list and returns that element multiplied by 3.

### Function Types

Before you can return a lambda expression from a function, you first need to understand function types.

You have already learned about basic types but functions themselves also have a type. Kotlin's type inference can 
infer a function's type from the parameter type. But there may be times when you need to explicitly 
specify the function type. The compiler needs the function type so that it knows what is and isn't allowed 
for that function.

The syntax for a function type has:

- Each parameter's type written within parentheses `()` and separated by commas `,`.

- The return type written after `->`.

For example: `(String) -> String` or `(Int, Int) -> Int`.

This is what a lambda expression looks like if a function type for `upperCaseString()` is defined:

```kotlin
val upperCaseString: (String) -> String = { text -> text.uppercase() }

fun main() {
    println(upperCaseString("hello"))
    // HELLO
}
```

If your lambda expression has no parameters then the parentheses `()` are left empty. 
For example: `() -> Unit`

### Return From a Function

Lambda expressions can be returned from a function. So that the compiler understands what type the lambda expression 
returned is, you must declare a function type.

In the following example, the `toSeconds()` function has function type `(Int) -> Int` because it always returns 
a lambda expression that takes a parameter of type `Int` and returns an `Int` value.

This example uses a `when` expression to determine which lambda expression is returned when `toSeconds()` is called:

```kotlin
fun toSeconds(time: String): (Int) -> Int = when (time) {
    "hour" -> { value -> value * 60 * 60 }
    "minute" -> { value -> value * 60 }
    "second" -> { value -> value }
    else -> { value -> value }
}

fun main() {
    val timesInMinutes = listOf(2, 10, 15, 1)
    val min2sec = toSeconds("minute")
    val totalTimeInSeconds = timesInMinutes.map(min2sec).sum()
    println("Total time is $totalTimeInSeconds secs")
    // Total time is 1680 secs
}
```

### Invoke Separately

Lambda expressions can be invoked on their own by adding parentheses `()` after the curly braces `{}` and including 
any parameters within the parentheses:

```kotlin
println({ text: String -> text.uppercase() }("hello"))
// HELLO
```

### Trailing Lambdas

As you have already seen, if a lambda expression is the only function parameter, you can drop 
the function parentheses `()`. If a lambda expression is passed as the last parameter of a function, 
then the expression can be written outside the function parentheses `()`. 
In both cases, this syntax is called a trailing lambda.

For example, the `.fold()` function accepts an initial value and an operation:

```kotlin
// The initial value is zero. 
// The operation sums the initial value with every item in the list cumulatively.
println(listOf(1, 2, 3).fold(0, { x, item -> x + item })) // 6

// Alternatively, in the form of a trailing lambda
println(listOf(1, 2, 3).fold(0) { x, item -> x + item })  // 6
```