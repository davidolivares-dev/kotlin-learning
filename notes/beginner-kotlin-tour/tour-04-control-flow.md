# Tour Control Flow

Like other programming languages, Kotlin is capable of making decisions based on whether a piece of code 
is evaluated to be true.  Such pieces of code are called conditional expressions. Kotlin is also able to create 
and iterate through loops.

## Conditional Expressions

Kotlin provides `if` and `when` for checking conditional expressions.

If choosing between `if` and `when` it is recommended to use `when` because:

- Makes your code easier to read.
- Makes it easier to add another branch.
- Leads to fewer mistakes in your code.

### If

To use `if`, add the conditional expression within parentheses `()` and the action to take if the result is true 
within curly braces `{}`

```kotlin
val d: Int
val check = true

if (check) {
    d = 1
} else {
    d = 2
}

println(d)
```

`if` can be used as an expression. If there is only one line of code per action, the curly braces `{}` are optional:

```kotlin
val a = 1
val b = 2

println(if (a > b) a else b)
```

### When

Use `when` when you have a conditional expression with multiple branches.

To use when:

- Place the value you want to evaluate within parentheses `()`.

- Place the branches within curly braces `{}`.

- Use `->` in each branch to separate each check from the action to take if the check is successful.

`when` can be used either as a statement or as an expression. A statement doesn't return anything but performs 
actions instead.

`when` as a statement:

```kotlin
val obj = "Hello"

when (obj) {
    // Checks whether obj equals to "1"
    "1" -> println("One")
    // Checks whether obj equals to "Hello"
    "Hello" -> println("Greeting")
    // Default statement
    else -> println("Unknown")     
}
```

`when` as an expression

```kotlin
val obj = "Hello"    

val result = when (obj) {
    // If obj equals "1", sets result to "one"
    "1" -> "One"
    // If obj equals "Hello", sets result to "Greeting"
    "Hello" -> "Greeting"
    // Sets result to "Unknown" if no previous condition is satisfied
    else -> "Unknown"
}
println(result)
```

`when` can also be used without a subject.
`when` expression without a subject to check a chain of Boolean expressions:

```kotlin
val trafficLightState = "Red" // This can be "Green", "Yellow", or "Red"

val trafficAction = when {
    trafficLightState == "Green" -> "Go"
    trafficLightState == "Yellow" -> "Slow down"
    trafficLightState == "Red" -> "Stop"
    else -> "Malfunction"
}

println(trafficAction)
```

## Ranges

Before talking about loops, it's useful to know how to construct ranges for loops to iterate over.

The most common way to create a range in Kotlin is to use the `..` operator. For example, `1..4` is equivalent 
to `1, 2, 3, 4`.

To declare a range that doesn't include the end value, use the `..<` operator. For example, `1..<4` is equivalent 
to `1, 2, 3`.

To declare a range in reverse order, use `downTo`. For example, `4 downTo 1` is equivalent to `4, 3, 2, 1`.

To declare a range that increments in a step that isn't 1, use `step` and your desired increment value. 
For example, `1..5 step 2` is equivalent to `1, 3, 5`.

You can also do the same with `Char` ranges:

- `'a'..'d'` is equivalent to `'a', 'b', 'c', 'd'`
- `'z' downTo 's' step 2` is equivalent to `'z', 'x', 'v', 't'`

## Loops

The two most common loop structures in programming are `for` and `while`. Use `for` to iterate over a range of values 
and perform an action. Use `while` to continue an action until a particular condition is satisfied.

### For

A for loop that iterates over numbers 1 to 5 and prints the number each time.
Place the iterator and range within parentheses `()` with keyword `in`. Add the action you want to complete within 
curly braces `{}`:

```kotlin
for (number in 1..5) { 
    // number is the iterator and 1..5 is the range
    print(number)
}
// 12345
```

Collections can also be iterated over by loops:

```kotlin
val cakes = listOf("carrot", "cheese", "chocolate")

for (cake in cakes) {
    println("Yummy, it's a $cake cake!")
}
// Yummy, it's a carrot cake!
// Yummy, it's a cheese cake!
// Yummy, it's a chocolate cake!
```

### While

`while` can be used in two ways:

- To execute a code block while a conditional expression is true. (`while`)

- To execute the code block first and then check the conditional expression. (`do-while`)

In the first use case (`while`):

- Declare the conditional expression for your while loop to continue within parentheses `()`.

- Add the action you want to complete within curly braces `{}`.

```kotlin
var cakesEaten = 0
while (cakesEaten < 3) {
    println("Eat a cake")
    cakesEaten++
}
// Eat a cake
// Eat a cake
// Eat a cake
```

In the second use case (`do-while`):

- Declare the conditional expression for your while loop to continue within parentheses `()`.

- Define the action you want to complete within curly braces `{}` with the keyword do.


```kotlin
var cakesEaten = 0
var cakesBaked = 0
while (cakesEaten < 3) {
    println("Eat a cake")
    cakesEaten++
}
do {
    println("Bake a cake")
    cakesBaked++
} while (cakesBaked < cakesEaten)
// Eat a cake
// Eat a cake
// Eat a cake
// Bake a cake
// Bake a cake
// Bake a cake
```