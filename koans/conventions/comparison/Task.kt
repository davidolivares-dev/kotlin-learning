/*
 * Kotlin Koans — Conventions #1: Comparison
 *
 * Task: Add compareTo to MyDate to make it Comparable, so `date1 < date2`
 * compiles. The comparison operators (<, >, <=, >=) all desugar to compareTo,
 * whose sign decides the order (negative = less, 0 = equal, positive = greater).
 * The override modifier is mandatory when overriding a member in Kotlin.
 *
 * Note: the `field - other.field` shortcut yields the right sign for small
 * values, but `a - b` can overflow for arbitrary Ints and flip the sign. It's
 * safe here (year/month/day ranges are tiny); in production prefer
 * compareValuesBy(this, other, MyDate::year, MyDate::month, MyDate::dayOfMonth).
 */

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate) = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }
}

fun test(date1: MyDate, date2: MyDate) {
    // this code should compile:
    println(date1 < date2)
}