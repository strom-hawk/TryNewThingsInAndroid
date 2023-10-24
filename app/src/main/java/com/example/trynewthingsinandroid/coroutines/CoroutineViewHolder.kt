package com.example.trynewthingsinandroid.coroutines

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.trynewthingsinandroid.data.Employee
import com.example.trynewthingsinandroid.utils.ApiStatus

@Composable
fun CoroutineViewHolder(viewModel: CoroutinePlayGroundViewModel) {
    val apiStatus = viewModel.apiStatus.collectAsState().value
    val employeeList = viewModel.employeeList.collectAsState().value

    EmployeeView(apiStatus, employeeList)
}

@Composable
fun EmployeeView(apiStatus: ApiStatus, employeeList: List<Employee>) {
    when (apiStatus) {
        ApiStatus.LOADING -> {
            Text(text = "Loading")
        }
        ApiStatus.FAILURE -> {
            Text(text = "Failure")
        }
        else -> {
            EmployeeListView(employeeList = employeeList)
        }
    }
}

@Composable
fun EmployeeListView(employeeList: List<Employee>) {
    LazyColumn() {
        items(employeeList.size) { index ->
            val employee = employeeList[index]
            Text(text = employee.employee_name)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}