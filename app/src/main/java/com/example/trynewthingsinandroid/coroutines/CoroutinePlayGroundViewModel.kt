package com.example.trynewthingsinandroid.coroutines

import androidx.lifecycle.ViewModel
import com.example.trynewthingsinandroid.network.BaseUrls
import com.example.trynewthingsinandroid.network.RetrofitClient
import com.example.trynewthingsinandroid.utils.log
import timber.log.Timber

class CoroutinePlayGroundViewModel : ViewModel() {
    private val tag = "CoroutinePlayGroundViewModel"

    init {
        log(tag, "init called")
        getEmployee()
    }

    private fun getEmployee() {
        val retrofitInstance = RetrofitClient.getInstance(BaseUrls.DUMMY_API)
        log(tag, "$retrofitInstance")
    }
}