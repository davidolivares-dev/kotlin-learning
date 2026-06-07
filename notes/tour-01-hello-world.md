# Tour Hello World Notes

## In Kotlin

- `fun` used to declare function
- `main()` is where program starts
- `.kts` files run top-to-bottom like a script. `main()` is for compiled `.kt` files.
- `println()` and `print()` functions print their arguments to standard output and are `top-level functions`
- `Kotlin` lets you define top-level functions that don't belong to any class; in `Java`, everything must live inside a class

## Variables

- Read-only variables `val`
- Mutable variables `var`
- `val` is preferred for variables, only use `var` when truly needed
- If `val` references mutable object only the reference is immutable, object can be modified.

## String Templates

- Use template expressions to access data in variables and other objects
- Template expressions always start with a dollar sign `$`
- To evaluate code in a template expression place code within curly braces `{}`
