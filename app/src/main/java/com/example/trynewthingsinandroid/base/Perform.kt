package com.example.trynewthingsinandroid.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trynewthingsinandroid.utils.log
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun ViewModel.perform(block: suspend () -> Unit) {
    this.viewModelScope.launch(Dispatchers.IO + handler) {
        block()
    }
}

private val handler = CoroutineExceptionHandler { context, exception ->
    log("Coroutine Exception Handler", "Caught $exception")
}