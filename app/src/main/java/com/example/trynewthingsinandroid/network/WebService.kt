package com.example.trynewthingsinandroid.network

import com.example.trynewthingsinandroid.data.CoroutinesResponse
import retrofit2.Response
import retrofit2.http.GET

interface WebService {
    @GET("employees")
    suspend fun getEmployeeDetails() : Response<CoroutinesResponse>
}