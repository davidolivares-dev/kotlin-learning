/*
 * Kotlin Koans — Introduction #2: Named arguments
 *
 * Task: Make joinOptions() return the collection in JSON-array format
 * (e.g. [a, b, c]) by passing only two arguments to joinToString.
 */

fun joinOptions(options: Collection<String>) =
        options.joinToString(prefix = "[", postfix = "]")
