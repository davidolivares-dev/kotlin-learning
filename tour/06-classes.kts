#!/usr/bin/env kotlin

import kotlin.random.Random

// Exercise 1
// Define a data class Employee with two properties: one for a name, and another for a salary.
// Make sure that the property for salary is mutable, otherwise you won't get a salary boost at the end of the year!
// The main function demonstrates how you can use this data class.

// Write your code here
data class Employee(val name: String, var salary: Int)

val emp = Employee("Mary", 20)
println(emp)
emp.salary += 10
println(emp)

println()

// Exercise 2
// Declare the additional data classes that are needed for this code to compile.
// data class Person(val name: Name, val address: Address, val ownsAPet: Boolean = true)
// Write your code here
// data class Name(...)

// fun main() {
//     val person = Person(
//         Name("John", "Smith"),
//         Address("123 Fake Street", City("Springfield", "US")),
//         ownsAPet = false
//     )
// }

data class Person(val name: Name, val address: Address, val ownsAPet: Boolean = true)

// Write your code here
data class Name(val firstName: String, val lastName: String)
data class Address(val street: String, val city: City)
data class City(val name: String, val country: String)

val person = Person(
    Name("John", "Smith"),
    Address("123 Fake Street", City("Springfield", "US")),
    ownsAPet = false
)

println(person)

println()

// Exercise 3
// To test your code, you need a generator that can create random employees.
// Define a RandomEmployeeGenerator class with a fixed list of potential names (inside the class body).
// Configure the class with a minimum and maximum salary (inside the class header).
// In the class body, define the generateEmployee() function. Once again, the main function demonstrates
// how you can use this class.

//    import kotlin.random.Random
//
//    data class Employee(val name: String, var salary: Int)
//
//    // Write your code here
//
//    fun main() {
//        val empGen = RandomEmployeeGenerator(10, 30)
//        println(empGen.generateEmployee())
//        println(empGen.generateEmployee())
//        println(empGen.generateEmployee())
//        empGen.minSalary = 50
//        empGen.maxSalary = 100
//        println(empGen.generateEmployee())
//    }

// Write your code here
class RandomEmployeeGenerator(var minSalary: Int = 0, var maxSalary: Int = 100) {
    private val employees = listOf("John", "Jane", "Mary", "William", "Jose", "Michael", "Winston", "Alice")

    fun generateEmployee(): Employee {
        return Employee(
            employees.random(),
            Random.nextInt(minSalary, maxSalary)
        )
    }
}

val empGen = RandomEmployeeGenerator(10, 30)
println(empGen.generateEmployee())
println(empGen.generateEmployee())
println(empGen.generateEmployee())
empGen.minSalary = 50
empGen.maxSalary = 100
println(empGen.generateEmployee())
