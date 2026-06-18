#!/usr/bin/env kotlin

// Exercise 1
// Rewrite the `.getPriceInEuros()` function as a single-expression function that uses safe call operators `?.`
// and the let scope function.
data class ProductInfo(val priceInDollars: Double?)

class Product {
    fun getProductInfo(): ProductInfo? {
        return ProductInfo(100.0)
    }
}

// Rewrite this function
// fun Product.getPriceInEuros(): Double? {
//     val info = getProductInfo()
//     if (info == null) return null
//     val price = info.priceInDollars
//     if (price == null) return null
//     return convertToEuros(price)
// }

fun Product.getPriceInEuros() = getProductInfo()?.priceInDollars?.let { convertToEuros(it) }

fun convertToEuros(dollars: Double): Double {
    return dollars * 0.85
}

val product = Product()
val priceInEuros = product.getPriceInEuros()

if (priceInEuros != null) {
    println("Price in Euros: €$priceInEuros")
    // Price in Euros: €85.0
} else {
    println("Price information is not available.")
}

// Exercise 2
// You have an `updateEmail()` function that updates the email address of a user.
// Use the apply scope function to update the email address and then the also scope function to
// print a log message: Updating email for user with ID: ${it.id}.
data class User(val id: Int, var email: String)

fun updateEmail(user: User, newEmail: String): User = user.apply {
    email = newEmail
}.also { println("Updating email for user with ID: ${it.id}") }


val user = User(1, "old_email@example.com")
val updatedUser = updateEmail(user, "new_email@example.com")
// Updating email for user with ID: 1

println("Updated User: $updatedUser")
// Updated User: User(id=1, email=new_email@example.com)

