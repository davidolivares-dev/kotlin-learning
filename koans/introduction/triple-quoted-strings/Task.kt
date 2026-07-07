/*
 * Kotlin Koans — Introduction #4: Triple-quoted strings
 *
 * Task: Replace the trimIndent call with a trimMargin call taking # as the
 * prefix value, so the resulting string doesn't contain the prefix character.
 */

const val question = "life, the universe, and everything"
const val answer = 42

val tripleQuotedString = """
    #question = "$question"
    #answer = $answer""".trimMargin("#")

fun main() {
    println(tripleQuotedString)
}