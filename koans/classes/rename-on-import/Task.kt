/*
 * Kotlin Koans — Classes #4: Rename on import
 *
 * Task: Uncomment the code and make it compile. Rename Random from the kotlin
 * package to KRandom, and Random from the java package to JRandom, using
 * import ... as aliases.
 */

import kotlin.random.Random as KRandom
import java.util.Random as JRandom

fun useDifferentRandomClasses(): String {
    return "Kotlin random: " +
            KRandom.nextInt(2) +
            " Java random:" +
            JRandom().nextInt(2) +
            "."
}