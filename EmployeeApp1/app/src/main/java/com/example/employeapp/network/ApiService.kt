package com.example.employeapp.network

import com.example.employeapp.model.CreateEmployeeRequest
import com.example.employeapp.model.EmployeeDetailResponse
import com.example.employeapp.model.EmployeeResponse
import com.example.employeapp.model.UpdateEmployeeRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.PATCH
import retrofit2.http.DELETE

interface ApiService {
    // handle endpoint base url + /get employees
    @GET("employees")
    fun getAllEmployes(): Call<EmployeeResponse>

    @GET("employee/{id}")
    fun getAllEmployeDetail(
        @Path("id") id: Int
    ): Call<EmployeeDetailResponse>

    @POST("create")
    fun createEmployee(
        @Body body: CreateEmployeeRequest
    ): Call<EmployeeDetailResponse>

    @PATCH("update/{id}")
    fun updateEmployee(
        @Path("id") id: Int,
        @Body body: UpdateEmployeeRequest
    ): Call<EmployeeDetailResponse>

    // TAMBAHAN UNTUK DELETE
    @DELETE("delete/{id}")
    fun deleteEmployee(
        @Path("id") id: Int
    ): Call<Void>
}