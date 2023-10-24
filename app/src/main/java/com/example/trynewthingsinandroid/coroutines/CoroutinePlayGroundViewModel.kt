package com.example.trynewthingsinandroid.coroutines

import androidx.lifecycle.ViewModel
import com.example.trynewthingsinandroid.base.perform
import com.example.trynewthingsinandroid.data.Employee
import com.example.trynewthingsinandroid.network.BaseUrls
import com.example.trynewthingsinandroid.network.RetrofitClient
import com.example.trynewthingsinandroid.network.WebService
import com.example.trynewthingsinandroid.utils.ApiStatus
import com.example.trynewthingsinandroid.utils.log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import timber.log.Timber

class CoroutinePlayGroundViewModel : ViewModel() {
    private val tag = "CoroutinePlayGroundViewModel"

    private val _apiStatus = MutableStateFlow(ApiStatus.LOADING)
    val apiStatus = _apiStatus

    private val _employeeList = MutableStateFlow<List<Employee>>(listOf())
    val employeeList: StateFlow<List<Employee>> = _employeeList

    init {
        log(tag, "init called")
        getEmployee()
    }

    private fun getEmployee() {
        val webService =
            RetrofitClient.getInstance(BaseUrls.DUMMY_API).create(WebService::class.java)
        perform {
            val employeeDetailsApi = webService.getEmployeeDetails()
            apiStatus.value = ApiStatus.FAILURE
            if (employeeDetailsApi.isSuccessful) {
                val responseBody = employeeDetailsApi.body()
                responseBody?.let { response ->
                    _employeeList.emit(response.data)
                    apiStatus.value = ApiStatus.SUCCESS
                }
            }
        }
    }
}