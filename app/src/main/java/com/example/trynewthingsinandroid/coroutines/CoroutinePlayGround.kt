package com.example.trynewthingsinandroid.coroutines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.trynewthingsinandroid.ui.components.PrimaryButton
import com.example.trynewthingsinandroid.ui.theme.TryNewThingsInAndroidTheme
import com.example.trynewthingsinandroid.utils.log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutinePlayGround : ComponentActivity() {

    private val TAG = "CoroutinePlayGround"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TryNewThingsInAndroidTheme() {
                val viewModel = ViewModelProvider(this)[CoroutinePlayGroundViewModel::class.java]
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.DarkGray)
                        .padding(16.dp),

                ) {
                    PrimaryButton(title = "Global Scope") {
                        testGlobalScope()
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    PrimaryButton(title = "Global Scope with delay") {
                        testGlobalScopeWithDelay()
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
    private fun testGlobalScope() {
        GlobalScope.launch {
            log(TAG, "GlobalScope says hello from thread ${Thread.currentThread().name}")
        }
        log(TAG, "Hello from thread ${Thread.currentThread().name}")
    }

    private fun testGlobalScopeWithDelay() {
        GlobalScope.launch {
            delay(3000L)
            log(TAG, "GlobalScope says hello from thread ${Thread.currentThread().name}")
        }
        log(TAG, "Hello from thread ${Thread.currentThread().name}")
    }
}