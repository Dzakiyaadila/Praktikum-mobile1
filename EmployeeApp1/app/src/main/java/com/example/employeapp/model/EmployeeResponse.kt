package com.example.employeapp.model

import com.google.gson.annotations.SerializedName

data class EmployeeResponse(
    @SerializedName("data")
    val data: List<Employee>
)
