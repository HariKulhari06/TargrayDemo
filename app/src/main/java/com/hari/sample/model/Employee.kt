package com.hari.sample.model

import com.jpvs0101.currencyfy.Currencyfy.currencyfy
import java.util.*

data class Employee(
    val id: Int = 0,
    val name: String? = null,
    val gender: String? = null,
    val age: Int? = null,
    val address: String? = null,
    val salary: Double? = null,
){

    fun formatedSalary() = currencyfy(Locale("en", "in"),salary?:0.0 )
    fun isMale()=Gender.getGender(gender ?: "Male")==Gender.MALE
    fun isFemale()=Gender.getGender(gender ?: "Female")==Gender.FEMALE

    companion object{
        val EMPTY = Employee()
         val TEST_EMPLOYEE = Employee(
             name = "Hari Singh Kulhari",
             gender = "Male",
             age = 28,
             salary = 520000.0,
             address = "317 Pratap Apartment - LIG Block, Sector 29, Pratap Nagar, Jaipur, Rajasthan 302022"
         )
    }
}