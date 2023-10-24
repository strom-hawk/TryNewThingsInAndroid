package com.example.trynewthingsinandroid

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.trynewthingsinandroid.coroutines.CoroutinePlayGround
import com.example.trynewthingsinandroid.ui.components.PrimaryButton
import com.example.trynewthingsinandroid.ui.theme.TryNewThingsInAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TryNewThingsInAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    PrimaryButton(
                        title = "Coroutine Example"
                    ) {
                        navigateToCoroutineActivity()
                    }
                }
            }
        }
    }

    private fun navigateToCoroutineActivity() {
        Intent(this, CoroutinePlayGround::class.java).also { intent ->
            startActivity(intent)
        }
    }
}