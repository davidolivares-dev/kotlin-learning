/*
 * Kotlin Koans — Conventions #5: Invoke
 *
 * Task: Implement Invokable.invoke() to count how many times it is invoked.
 * An operator fun invoke() lets an object be called like a function:
 * obj() desugars to obj.invoke(). Returning this enables chained calls.
 */

class Invokable {
    var numberOfInvocations: Int = 0
        private set

    operator fun invoke(): Invokable {
        numberOfInvocations++
        return this
    }
}

fun invokeTwice(invokable: Invokable) = invokable()()