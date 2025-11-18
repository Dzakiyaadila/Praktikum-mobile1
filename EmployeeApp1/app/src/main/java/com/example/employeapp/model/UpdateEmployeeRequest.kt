// UpdateEmployeeRequest.kt
package com.example.employeapp.model

data class UpdateEmployeeRequest(
    val name: String? = null,
    val salary: Int? = null,
    val age: Int? = null
)