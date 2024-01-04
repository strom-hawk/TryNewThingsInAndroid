package com.example.trynewthingsinandroid.custom_components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trynewthingsinandroid.ui.theme.TryNewThingsInAndroidTheme
import com.example.trynewthingsinandroid.utils.ColorSystem

class CustomComponents : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TryNewThingsInAndroidTheme() {
                MainButtonCall()
            }
        }
    }
}

@Composable
fun MainButtonCall() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Gray)
            .padding(horizontal = 16.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        /*ElevatedButton("Click me") {

        }

        Spacer(modifier = Modifier.height(16.dp))

        FlatButton("Click me") {

        }

        Spacer(modifier = Modifier.height(16.dp))

        NonFloatingTiltButton("Click me") {

        }

        Spacer(modifier = Modifier.height(16.dp))

        NonFloatingTiltButton(
            text = "Click me",
            textColor = ColorSystem.white,
            faceColor = ColorSystem.blue_300,
            bottomBackground = ColorSystem.blue_700
        ) {}

        Spacer(modifier = Modifier.height(16.dp))*/

        CircularProgressBar(
            text = "80 %",
            fontSize = 24.sp,
            diameter = 100.dp,
            backgroundColor = ColorSystem.green_100,
            foregroundColor = ColorSystem.green_500,
            strokeWidth = 12F,
            shouldFillBackground = true,
            needBackgroundStroke = false
        )

        Spacer(modifier = Modifier.height(16.dp))

        CircularProgressBar(
            text = "80 %",
            fontSize = 48.sp,
            diameter = 200.dp,
            backgroundColor = ColorSystem.green_100,
            foregroundColor = ColorSystem.green_500,
            strokeWidth = 50F,
            shouldFillBackground = true,
            needBackgroundStroke = false
        )

        Spacer(modifier = Modifier.height(16.dp))

        CircularProgressBar(
            text = "80 %",
            fontSize = 50.sp,
            diameter = 200.dp,
            backgroundColor = ColorSystem.blue_100,
            foregroundColor = ColorSystem.blue_500,
            strokeWidth = 50F,
            shouldFillBackground = false,
            needBackgroundStroke = true
        )
    }
}

@Preview()
@Composable
fun PopUpButtonPreview() {
    MainButtonCall()
}