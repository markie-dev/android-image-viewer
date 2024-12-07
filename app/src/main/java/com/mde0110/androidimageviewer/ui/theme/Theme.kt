package com.mde0110.androidimageviewer.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color.Black,
    secondary = Color.Black,
    tertiary = Color.Black,
    surface = Color(0xFF1A1A1A),
    onSurface = Color.White,
    primaryContainer = Color(0xFF2D2D2D),
    onPrimaryContainer = Color.Black
)

private val LightColorScheme = lightColorScheme(
    primary = Color.Black,
    secondary = Color.Black,
    tertiary = Color.Black,
    surface = Color(0xFFF5F5F5),
    onSurface = Color.Black,
    primaryContainer = Color(0xFFE1E1E1),
    onPrimaryContainer = Color.Black
)

@Composable
fun AndroidimageviewerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}