package com.example.trynewthingsinandroid.custom_components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.trynewthingsinandroid.utils.ColorSystem

/**
 * Created by Saurav Suman on 26/12/23.
 */

@Composable
fun FlatButton(
    text: String,
    width: Dp = 160.dp,
    height: Dp = 40.dp,
    textColor: Color = Color.Black,
    backgroundColor: Color = Color.Gray,
    faceColor: Color = ColorSystem.white,
    bottomBackground: Color = ColorSystem.grey_300,
    sideBackground: Color = ColorSystem.grey_200,
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
            SimpleButton(
                width = width,
                height = height,
                backgroundColor = backgroundColor,
                faceColor = faceColor,
                xAndyPadding = 0F
            ) {
                CustomText(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, bottom = 0.dp, top = 0.dp),
                    text = text,
                    textColor = textColor
                )
            }
        } else {
            PressedStateButton(
                width = width,
                height = height,
                text = text,
                textColor = textColor,
                backgroundColor = backgroundColor,
                faceColor = faceColor,
                bottomBackground = bottomBackground,
                sideBackground = sideBackground
            )
        }
    }
}

@Composable
private fun PressedStateButton(
    width: Dp,
    height: Dp,
    text: String,
    textColor: Color,
    backgroundColor: Color,
    faceColor: Color,
    bottomBackground: Color,
    sideBackground: Color
) {
    val modifier = Modifier
        .width(width)
        .height(height)

    Box(
        modifier = modifier
            .background(faceColor),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = modifier
                .background(backgroundColor)
        ) {

            val canvasHeight = size.height
            val canvasWidth = size.width
            val padding = 8F

            val facePath = Path()
            facePath.moveTo(x = padding, y = padding)
            facePath.lineTo(x = canvasWidth, y = padding)
            facePath.lineTo(x = canvasWidth, y = canvasHeight)
            facePath.lineTo(x = padding, y = canvasHeight)
            drawPath(facePath, faceColor)

            val topPath = Path()
            topPath.moveTo(x = 0F, y = 0F)
            topPath.lineTo(x = canvasWidth, y = 0F)
            topPath.lineTo(x = canvasWidth, y = padding)
            topPath.lineTo(x = padding, padding)
            drawPath(topPath, ColorSystem.grey_800)

            val leftPath = Path()
            leftPath.moveTo(x = 0F, y = 0F)
            leftPath.lineTo(x = 0F, y = canvasHeight)
            leftPath.lineTo(x = padding, y = canvasHeight)
            leftPath.lineTo(x = padding, y = padding)
            drawPath(leftPath, ColorSystem.grey_700)

        }

        CustomText(
            modifier = Modifier
                .padding(start = 8.dp, end = 0.dp, bottom = 0.dp, top = 8.dp),
            text = text,
            textColor = textColor
        )
    }
}

@Preview()
@Composable
fun FlatButtonPreview() {
    FlatButton("Click me") {}
}