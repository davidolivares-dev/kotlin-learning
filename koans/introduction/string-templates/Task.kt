/*
 * Kotlin Koans — Introduction #5: String templates
 *
 * Task: Using the month variable, rewrite the date-matching regex pattern so
 * it matches the format 13 JUN 1992 (two digits, one whitespace, a month
 * abbreviation, one whitespace, four digits).
 */

val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

fun getPattern(): String = """\d{2} $month \d{4}"""