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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trynewthingsinandroid.utils.ColorSystem

/**
 * Created by Saurav Suman on 26/12/23.
 */
@Composable
fun ElevatedButton(
    text: String,
    width: Dp = 150.dp,
    height: Dp = 36.dp,
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
            PopUpButton(
                width = width,
                height = height,
                text = text,
                textColor = textColor,
                backgroundColor = backgroundColor,
                faceColor = faceColor,
                bottomBackground = bottomBackground,
                sideBackground = sideBackground
            )
        } else {
            SimpleButton(
                width = width,
                height = height,
                text = text,
                textColor = textColor,
                backgroundColor = backgroundColor,
                faceColor = faceColor
            )
        }
    }
}

@Composable
private fun SimpleButton(
    width: Dp,
    height: Dp,
    text: String,
    textColor: Color,
    backgroundColor: Color,
    faceColor: Color
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
            val padding = 10F

            val facePath = Path()
            facePath.moveTo(x = padding, y = padding)
            facePath.lineTo(x = canvasWidth, y = padding)
            facePath.lineTo(x = canvasWidth, y = canvasHeight)
            facePath.lineTo(x = padding, y = canvasHeight)
            drawPath(facePath, faceColor)
        }

        CustomText(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, bottom = 0.dp, top = 0.dp),
            text = text,
            textColor = textColor
        )
    }
}

@Composable
private fun PopUpButton(
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

        CustomText(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, bottom = 4.dp, top = 0.dp),
            text = text,
            textColor = textColor
        )
    }
}


@Composable
private fun CustomText(
    modifier: Modifier,
    text: String,
    textColor: Color
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 12.sp,
        color = textColor,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        textAlign = TextAlign.Center
    )
}