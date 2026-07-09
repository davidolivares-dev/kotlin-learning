/*
 * Kotlin Koans — Classes #3: Sealed classes
 *
 * Task: Reuse the smart-casts solution, but make Expr a sealed interface.
 * The when is then exhaustive, so the else branch is no longer needed.
 */

fun eval(expr: Expr): Int =
    when (expr) {
        is Num -> expr.value
        is Sum -> eval(expr.left) + eval(expr.right)
    }

sealed interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr