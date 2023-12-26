package com.example.trynewthingsinandroid.coroutines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.trynewthingsinandroid.ui.components.PrimaryButton
import com.example.trynewthingsinandroid.ui.theme.TryNewThingsInAndroidTheme
import com.example.trynewthingsinandroid.utils.log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import timber.log.Timber
import kotlin.system.measureTimeMillis

class CoroutinePlayGround : ComponentActivity() {

    private val TAG = "CoroutinePlayGround"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TryNewThingsInAndroidTheme() {
                val viewModel = ViewModelProvider(this)[CoroutinePlayGroundViewModel::class.java]
                val logText = remember { mutableStateOf("") }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.DarkGray)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.SpaceBetween

                    ) {
                    Column {
                        PrimaryButton(title = "Global Scope") {
                            logText.value = ""
                            testGlobalScope(logText)
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        PrimaryButton(title = "Global Scope with delay") {
                            logText.value = ""
                            testGlobalScopeWithDelay(logText)
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        PrimaryButton(title = "Suspend function") {
                            testSuspendFunctions()
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        PrimaryButton(title = "Test runBlocking{}") {
                            testRunBlocking()
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        PrimaryButton(title = "Test join()") {
                            testJoin()
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        PrimaryButton(title = "Async() and await()") {
                            logText.value = ""
                            testAsyncAndAwait(logText)
                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.4F)
                            .background(color = Color.LightGray, shape = RoundedCornerShape(12.dp))
                            .padding(16.dp)
                            .verticalScroll(rememberScrollState())
                    ) {
                        Text(
                            text = logText.value,
                            fontSize = 12.sp,
                            color = Color.Black
                        )
                    }

                    /*PrimaryButton(title = "Employee list example") {
                        CoroutineViewHolder(viewModel)
                    }*/
                }
            }
        }
    }

    /**
     * This function shows that GlobalScope is launched in a different thread from main thread.
     */
    private fun testGlobalScope(logText: MutableState<String>) {
        GlobalScope.launch {
            logText.value += "GlobalScope says hello from thread ${Thread.currentThread().name}.\n"
        }
        logText.value += "Hello from thread ${Thread.currentThread().name}.\n"
    }

    private fun testGlobalScopeWithDelay(logText: MutableState<String>) {
        GlobalScope.launch {
            delay(3000L)
            logText.value += "GlobalScope says hello from thread ${Thread.currentThread().name}.\n"
        }
        logText.value += "Hello from thread ${Thread.currentThread().name}.\n"
    }


    private fun testSuspendFunctions() {
        var firstResponse = ""
        var secondResponse = ""

        GlobalScope.launch {
            firstResponse = firstNetworkCall()
            secondResponse = secondNetworkCall()

            log(TAG, firstResponse)
            log(TAG, secondResponse)
        }

        log(TAG, firstResponse)
        log(TAG, secondResponse)
    }

    private suspend fun firstNetworkCall(): String {
        delay(2000L)
        return "Response from first network call."
    }

    private suspend fun secondNetworkCall(): String {
        delay(2000L)
        return "Response from second network call."
    }

    private fun testRunBlocking() {
        log(TAG, "Starting run blocking")
        runBlocking {
            log(TAG, "Inside run blocking")
            delay(5000L)
            log(TAG, "Finishing run blocking")
        }
        log(TAG, "Outside run blocking")
    }

    private fun testJoin() {
        val time = measureTimeMillis {
            val task1 = GlobalScope.launch { networkCall1() }
            val task2 = GlobalScope.launch { networkCall2() }

            runBlocking {
                task1.join()
                task2.join()
                Timber.d("Both task execution finished")
            }
        }
        Timber.d("Total time taken: $time ms.\n")
    }

    private fun testAsyncAndAwait(logText: MutableState<String>) {
        lifecycleScope.launch {
            val time = measureTimeMillis {
                logText.value += "Network call 1 fired.\n"
                val response1 = async { networkCall1() }
                logText.value += "Response 1: ${response1.await()}\n"

                logText.value += "Network call 2 fired.\n"
                val response2 = async { networkCall2() }
                logText.value += "Response 2: ${response2.await()}\n"

                logText.value += "Final response.\n"
                logText.value += "Response 1: ${response1.await()}\n"
                logText.value += "Response 2: ${response2.await()}\n"
            }

            logText.value += "Total time taken: $time ms.\n"
        }
    }

    private suspend fun networkCall1(): String {
        delay(3000L)
        return "Network call 1 response"
    }
    private suspend fun networkCall2(): String {
        delay(2000L)
        return "Network call 2 response"
    }
}