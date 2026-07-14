/*
 * Kotlin Koans — Conventions #3: For loop
 *
 * Task: Make DateRange implement Iterable<MyDate> so it works in a for loop.
 * Return the iterator as an object expression (Kotlin's anonymous class),
 * using MyDate.followingDate() from DateUtil.kt to advance one day at a time.
 * Iterator idiom in next(): capture current, advance the cursor, return the
 * captured value; hasNext() uses <= so the end date is included.
 */

class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            var current: MyDate = start

            override fun next(): MyDate {
                if (!hasNext()) throw NoSuchElementException()
                val result = current
                current = current.followingDate()
                return result
            }

            override fun hasNext(): Boolean = current <= end
        }
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}