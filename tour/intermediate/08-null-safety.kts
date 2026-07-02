#!/usr/bin/env kotlin

data class User(val name: String?)

// Exercise 1
// You are developing a notification system for an app where users can enable or disable different types
// of notifications. Complete the getNotificationPreferences() function so that:
// 1. The validUser variable uses the as? operator to check if user is an instance of the User class. If it isn't, return an empty list.

// 2. The userName variable uses the Elvis ?: operator to ensure that the user's name defaults to "Guest" if it is null.

// 3. The final return statement uses the .takeIf() function to include email and SMS notification preferences only if they are enabled.

// 4. The main() function runs successfully and prints the expected output.
fun getNotificationPreferences(user: Any, emailEnabled: Boolean, smsEnabled: Boolean): List<String> {
    val validUser = user as? User ?: return emptyList() // Write your code here
    val userName = validUser.name ?: "Guest" // Write your code here

    return listOfNotNull(
        "Email Notifications enabled for $userName".takeIf { emailEnabled },
        "SMS Notifications enabled for $userName".takeIf { smsEnabled }
    )
}

val user1 = User("Alice")
val user2 = User(null)
val invalidUser = "NotAUser"

println(getNotificationPreferences(user1, emailEnabled = true, smsEnabled = false))
// [Email Notifications enabled for Alice]
println(getNotificationPreferences(user2, emailEnabled = false, smsEnabled = true))
// [SMS Notifications enabled for Guest]
println(getNotificationPreferences(invalidUser, emailEnabled = true, smsEnabled = true))
// []

println()

// Exercise 2
// You are working on a subscription-based streaming service where users can have multiple subscriptions,
// but only one can be active at a time. Complete the getActiveSubscription() function so that it uses the
// singleOrNull() function with a predicate to return a null value if there is more than one active subscription:
data class Subscription(val name: String, val isActive: Boolean)

fun getActiveSubscription(subscriptions: List<Subscription>): Subscription? =
    subscriptions.singleOrNull { sub -> sub.isActive} // Write your code here

val userWithPremiumPlan = listOf(
    Subscription("Basic Plan", false),
    Subscription("Premium Plan", true)
)

val userWithConflictingPlans = listOf(
    Subscription("Basic Plan", true),
    Subscription("Premium Plan", true)
)

println(getActiveSubscription(userWithPremiumPlan))
// Subscription(name=Premium Plan, isActive=true)

println(getActiveSubscription(userWithConflictingPlans))
// null

println()

// Exercise 3
// You are working on a social media platform where users have usernames and account statuses.
// You want to see the list of currently active usernames. Complete the getActiveUsernames() function so that
// the mapNotNull() function has a predicate that returns the username if it is active or a null value if it isn't:
data class User3(val username: String, val isActive: Boolean)

fun getActiveUsernames(users: List<User3>): List<String> {
    return users.mapNotNull { user ->
        if (user.isActive) user.username else null
    }
}

val allUsers = listOf(
    User3("alice123", true),
    User3("bob_the_builder", false),
    User3("charlie99", true)
)

println(getActiveUsernames(allUsers))
// [alice123, charlie99]

println()

// Exercise 4
// You are working on an inventory management system for an e-commerce platform. Before processing a sale,
// you need to check if the requested quantity of a product is valid based on the available stock.
// Complete the `validateStock()` function so that it uses early returns and the Elvis operator (where applicable)
// to check if:
// - The requested variable is null.
//
// - The available variable is null.
//
// - The requested variable is a negative value.
//
// - The amount in the requested variable is higher than in the available variable.
//
// In all of the above cases, the function must return early with the value of `-1`.
fun validateStock(requested: Int?, available: Int?): Int {
    // Write your code here
    val validRequested = requested ?: return -1
    val validAvailable = available ?: return -1

    if (validRequested < 0) return -1
    if (validRequested > validAvailable) return -1

    return validRequested
}

println(validateStock(5,10))
// 5
println(validateStock(null,10))
// -1
println(validateStock(-2,10))
// -1