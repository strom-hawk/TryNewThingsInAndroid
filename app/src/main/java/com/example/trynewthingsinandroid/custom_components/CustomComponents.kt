package com.example.trynewthingsinandroid.custom_components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
private fun SimpleButton(
    modifier: Modifier,
    faceColor: Color
) {
    Canvas(
        modifier = modifier
    ) {

        val canvasHeight = size.height
        val canvasWidth = size.width
        val padding = 10F

        val facePath = Path()
        facePath.moveTo(x = padding, y = padding)
        facePath.lineTo(x = canvasWidth, y = padding)
        facePath.lineTo(x = canvasWidth, y = canvasHeight)
        facePath.lineTo(x = padding, y = canvasHeight)
        drawPath(facePath, faceColor)
    }
}

@Composable
private fun PopUpButton(
    modifier: Modifier,
    faceColor: Color,
    bottomBackground: Color,
    sideBackground: Color
) {
    Canvas(
        modifier = modifier
    ) {

        val canvasHeight = size.height
        val canvasWidth = size.width
        val padding = 10F

        val facePath = Path()
        facePath.moveTo(x = 0F, y = 0F)
        facePath.lineTo(x = canvasWidth - padding, y = 0F)
        facePath.lineTo(x = canvasWidth - padding, y = canvasHeight - padding)
        facePath.lineTo(x = 0F, y = canvasHeight - padding)
        drawPath(facePath, faceColor)

        val sidePath = Path()
        sidePath.moveTo(x = canvasWidth - padding, y = 0F)
        sidePath.lineTo(x = canvasWidth - padding, y = canvasHeight - padding)
        sidePath.lineTo(x = canvasWidth, y = canvasHeight)
        sidePath.lineTo(x = canvasWidth, padding)
        drawPath(sidePath, sideBackground)

        val bottomPath = Path()
        bottomPath.moveTo(x = 0F, y = canvasHeight - padding)
        bottomPath.lineTo(x = padding, y = canvasHeight)
        bottomPath.lineTo(x = canvasWidth, y = canvasHeight)
        bottomPath.lineTo(x = canvasWidth - padding, y = canvasHeight - padding)
        drawPath(bottomPath, bottomBackground)

    }
}

@Composable
fun ElevatedButton(
    modifier: Modifier,
    faceColor: Color = Color.White,
    bottomBackground: Color = Color.White,
    sideBackground: Color = Color.White,
    onButtonClick: () -> Unit
) {
    val show = remember { mutableStateOf(value = true) }
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = interactionSource.collectIsPressedAsState()

    if (isPressed.value) {
        show.value = false
        DisposableEffect(Unit) {
            onDispose {
                show.value = true
            }
        }
    }

    Box(
        modifier = Modifier
            .padding(0.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = { onButtonClick() }
            )
    ) {
        if (show.value) {
            PopUpButton(
                modifier = modifier,
                faceColor = faceColor,
                bottomBackground = bottomBackground,
                sideBackground = sideBackground
            )
        } else {
            SimpleButton(
                modifier = modifier,
                faceColor = faceColor
            )
        }
    }
}

@Composable
fun MainButtonCall() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Black)
            .padding(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top
    ) {
        ElevatedButton(
            modifier = Modifier
                .width(150.dp)
                .height(36.dp)
                .background(color = Color.Black),
            faceColor = ColorSystem.white,
            bottomBackground = ColorSystem.grey_300,
            sideBackground = ColorSystem.grey_200,
        ) {

        }
    }
}

@Preview()
@Composable
fun PopUpButtonPreview() {
    MainButtonCall()
}