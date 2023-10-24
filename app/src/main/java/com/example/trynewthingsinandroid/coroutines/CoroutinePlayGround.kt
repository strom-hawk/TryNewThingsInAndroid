package com.example.trynewthingsinandroid.coroutines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.trynewthingsinandroid.ui.theme.TryNewThingsInAndroidTheme

class CoroutinePlayGround : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TryNewThingsInAndroidTheme {
                val viewModel = ViewModelProvider(this)[CoroutinePlayGroundViewModel::class.java]
                CoroutineViewHolder(viewModel)
            }
        }
    }
}