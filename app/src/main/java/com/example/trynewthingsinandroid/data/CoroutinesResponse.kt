package com.example.trynewthingsinandroid.data

data class CoroutinesResponse(
    val status: String,
    val message: String,
    val data: List<Employee>
)

data class Employee(
    val id: Int,
    val employee_name: String,
    val employee_salary: String,
    val employee_age: Int,
    val profile_age: String
)
