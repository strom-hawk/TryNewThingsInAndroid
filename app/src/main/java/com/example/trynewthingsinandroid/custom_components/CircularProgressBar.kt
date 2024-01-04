package com.example.trynewthingsinandroid.custom_components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trynewthingsinandroid.utils.ColorSystem

/**
 * Created by Saurav Suman on 03/01/24.
 */
@Composable
fun CircularProgressBar(
    text: String = "",
    textColor: Color = ColorSystem.black,
    textModifier: Modifier = Modifier,
    fontSize: TextUnit = 12.sp,
    diameter: Dp,
    backgroundColor: Color,
    foregroundColor: Color,
    strokeWidth: Float = 10F,
    shouldFillBackground: Boolean = false,
    needBackgroundStroke: Boolean = true
) {
    val modifier = Modifier
        .width(diameter)
        .height(diameter)

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = modifier
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height


            if (shouldFillBackground) {
                drawCircle(
                    color = backgroundColor,
                    radius = canvasHeight / 2 - strokeWidth + 1,
                    center = center,
                )
            }

            if (needBackgroundStroke) {
                drawArc(
                    color = backgroundColor,
                    topLeft = Offset(strokeWidth / 2, y = strokeWidth / 2),
                    startAngle = -90F,
                    sweepAngle = 360F,
                    useCenter = false,
                    size = Size(canvasWidth - strokeWidth, canvasHeight - strokeWidth),
                    style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                )
            }

            drawArc(
                color = foregroundColor,
                topLeft = Offset(x = strokeWidth / 2, y = strokeWidth / 2),
                startAngle = -90F,
                sweepAngle = 270F,
                useCenter = false,
                size = Size(canvasWidth - strokeWidth, canvasHeight - strokeWidth),
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
            )
        }

        Text(
            modifier = textModifier,
            text = text,
            fontSize = fontSize,
            color = textColor,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )

    }
}

@Preview()
@Composable
fun CircularProgressBarPreview() {
    CircularProgressBar(
        text = "80 %",
        fontSize = 8.sp,
        diameter = 36.dp,
        backgroundColor = ColorSystem.green_100,
        foregroundColor = ColorSystem.green_500,
        strokeWidth = 15F,
        shouldFillBackground = true,
        needBackgroundStroke = false
    )
}