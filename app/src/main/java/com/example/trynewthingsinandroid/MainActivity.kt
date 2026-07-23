package com.example.trynewthingsinandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.trynewthingsinandroid.home.HomeScreen
import com.example.trynewthingsinandroid.ui.theme.TryNewThingsInAndroidTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TryNewThingsInAndroidTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = stringResource(id = R.string.toolbar_title),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        )
                    }
                ) { paddingValues ->
                    HomeScreen(
                        modifier = Modifier.padding(paddingValues)
                    )
                }
            }
        }
    }
}
