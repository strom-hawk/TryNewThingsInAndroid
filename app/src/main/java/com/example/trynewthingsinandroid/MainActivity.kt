package com.example.trynewthingsinandroid

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.trynewthingsinandroid.coroutines.CoroutinePlayGround
import com.example.trynewthingsinandroid.custom_components.CustomComponents
import com.example.trynewthingsinandroid.ui.components.PrimaryButton
import com.example.trynewthingsinandroid.ui.theme.TryNewThingsInAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TryNewThingsInAndroidTheme {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                ) {
                    PrimaryButton(title = "Coroutine Example") {
                        navigateToCoroutineActivity()
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    PrimaryButton(title = "Custom Components") {
                        navigateToCustomComponentActivity()
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

    private fun navigateToCustomComponentActivity() {
        Intent(this, CustomComponents::class.java).also { intent ->
            startActivity(intent)
        }
    }
}