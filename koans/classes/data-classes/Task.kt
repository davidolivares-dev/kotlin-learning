/*
 * Kotlin Koans — Classes #1: Data classes
 *
 * Task: Rewrite the Java Person class in Kotlin, then add the data modifier so
 * the compiler generates equals/hashCode, toString, and other useful methods.
 */

data class Person(val name: String, val age: Int)

fun getPeople(): List<Person> {
    return listOf(Person("Alice", 29), Person("Bob", 31))
}

fun comparePeople(): Boolean {
    val p1 = Person("Alice", 29)
    val p2 = Person("Alice", 29)
    return p1 == p2  // should be true
}