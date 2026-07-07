/*
 * Kotlin Koans — Introduction #3: Default arguments
 *
 * Task: Replace several Java foo() overloads with one Kotlin function by
 * changing foo's declaration to use default and named arguments, so the
 * code in useFoo compiles.
 */

fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false) =
    (if (toUpperCase) name.uppercase() else name) + number

fun useFoo() = listOf(
    foo("a"),
    foo("b", number = 1),
    foo("c", toUpperCase = true),
    foo(name = "d", number = 2, toUpperCase = true)
)