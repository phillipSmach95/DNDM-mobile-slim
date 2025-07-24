package com.example.dndmanagerslim.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Typography
import androidx.compose.material3.CardDefaults

private val LightColors = lightColorScheme(
    primary = Color(0xFF6200EE),
    onPrimary = Color.White,
    secondary = Color(0xFF03DAC6),
    onSecondary = Color.Black,
    background = Color(0xFFF6F6F6),
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFBB86FC),
    onPrimary = Color.Black,
    secondary = Color(0xFF03DAC6),
    onSecondary = Color.Black,
    background = Color(0xFF121212),
    onBackground = Color.White,
    surface = Color(0xFF121212),
    onSurface = Color.White
)



@Composable
fun DndManagerSlimTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography(),
        content = content
    )
}