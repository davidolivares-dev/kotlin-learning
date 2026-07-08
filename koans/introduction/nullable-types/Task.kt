/*
 * Kotlin Koans — Introduction #6: Nullable types
 *
 * Task: Using null safety and safe calls, rewrite the Java version so it has
 * only one if expression (a safe-call chain plus a single null guard).
 */

fun sendMessageToClient(
    client: Client?, message: String?, mailer: Mailer
) {
    val email = client?.personalInfo?.email
    if (email == null || message == null) return

    mailer.sendMessage(email, message)
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}