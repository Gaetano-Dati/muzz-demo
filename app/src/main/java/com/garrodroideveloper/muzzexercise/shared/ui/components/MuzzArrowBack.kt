package com.garrodroideveloper.muzzexercise.shared.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Composable
fun MuzzArrowBack(): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "chevron_left",
            defaultWidth = 40.0.dp,
            defaultHeight = 40.0.dp,
            viewportWidth = 40.0f,
            viewportHeight = 40.0f,
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero,
            ) {
                moveTo(22.375f, 28.875f)
                lineToRelative(-8f, -8f)
                quadToRelative(-0.208f, -0.208f, -0.292f, -0.417f)
                quadToRelative(-0.083f, -0.208f, -0.083f, -0.5f)
                quadToRelative(0f, -0.25f, 0.083f, -0.479f)
                quadToRelative(0.084f, -0.229f, 0.292f, -0.437f)
                lineToRelative(8.042f, -8f)
                quadToRelative(0.375f, -0.417f, 0.916f, -0.417f)
                quadToRelative(0.542f, 0f, 0.959f, 0.417f)
                quadToRelative(0.375f, 0.375f, 0.354f, 0.937f)
                quadToRelative(-0.021f, 0.563f, -0.396f, 0.979f)
                lineToRelative(-7.042f, 7f)
                lineToRelative(7.084f, 7.084f)
                quadToRelative(0.375f, 0.375f, 0.375f, 0.916f)
                quadToRelative(0f, 0.542f, -0.375f, 0.917f)
                quadToRelative(-0.417f, 0.417f, -0.959f, 0.417f)
                quadToRelative(-0.541f, 0f, -0.958f, -0.417f)
                close()
            }
        }.build()
    }
}
