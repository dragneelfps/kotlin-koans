package iii_conventions


data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {

    override fun compareTo(other: MyDate): Int {
        return when {
            year != other.year -> year - other.year
            month != other.month -> month - other.month
            else -> dayOfMonth - other.dayOfMonth
        }
    }

}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

operator fun MyDate.plus(timeInterval: TimeInterval) = addTimeIntervals(timeInterval, 1)

operator fun MyDate.plus(repeatedTimeInterval: RepeatedTimeInterval) = addTimeIntervals(repeatedTimeInterval.timeInterval, repeatedTimeInterval.count)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

data class RepeatedTimeInterval(val timeInterval: TimeInterval, val count: Int)

operator fun TimeInterval.times(count: Int) = RepeatedTimeInterval(this, count)

class DateRange(override val start: MyDate, override val endInclusive: MyDate): ClosedRange<MyDate>, Iterable<MyDate> {

    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            var iter = start
            override fun hasNext(): Boolean {
                return iter <= endInclusive
            }

            override fun next(): MyDate {
                val tmp = iter
                iter = iter.nextDay()
                return tmp
            }
        }
    }
}


