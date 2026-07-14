/*
 * Kotlin Koans — Conventions #2: In range
 *
 * Task: Using ranges, check whether date falls between first and last
 * (inclusive). `in` desugars to a contains call and `..` to rangeTo; since
 * MyDate is Comparable, both come from the stdlib for free.
 */

fun checkInRange(date: MyDate, first: MyDate, last: MyDate): Boolean {
    return date in first..last
}