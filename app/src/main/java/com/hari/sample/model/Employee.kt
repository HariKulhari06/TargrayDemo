package com.hari.sample.model

data class Employee(
    val id: Int = 0,
    val name: String? = null,
    val gender: String? = null,
    val age: Int? = null,
    val address: String? = null,
    val salary: Double? = null,
){

    companion object{
         val TEST_EMPLOYEE = Employee(
            name = "Hari Singh Kulhari",
            gender = "Male",
            age = 28,
            salary = 520000.0,
            address = "317 Pratap Apartment - LIG Block, Sector 29, Pratap Nagar, Jaipur, Rajasthan 302022"
        )
    }
}