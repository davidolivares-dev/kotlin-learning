/*
 * Kotlin Koans — Classes #5: Extension functions
 *
 * Task: Implement the extension functions Int.r() and Pair.r() to convert an
 * Int and a Pair into a RationalNumber.
 */

fun Int.r(): RationalNumber = RationalNumber(this, 1)

fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(first, second)

data class RationalNumber(val numerator: Int, val denominator: Int)

