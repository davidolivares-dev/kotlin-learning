/*
 * Kotlin Koans — Conventions #4: Operator overloading
 *
 * Task: Implement date arithmetic so you can add years, weeks, and days to a
 * date, e.g. date + YEAR * 2 + WEEK * 3 + DAY * 15. First add MyDate.plus
 * taking a TimeInterval (via addTimeIntervals in DateUtil.kt). Then support
 * chaining several intervals with an extra class (RepeatedTimeInterval) plus
 * TimeInterval.times and a second MyDate.plus overload.
 */

import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR }

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = this.addTimeIntervals(timeInterval, 1)

// Extra helper class
data class RepeatedTimeInterval(val interval: TimeInterval, val count: Int)

operator fun MyDate.plus(repeated: RepeatedTimeInterval): MyDate = this.addTimeIntervals(repeated.interval, repeated.count)
operator fun TimeInterval.times(count: Int): RepeatedTimeInterval = RepeatedTimeInterval(this, count)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
