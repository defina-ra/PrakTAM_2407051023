package com.example.definaa.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val CheatDayColorScheme = lightColorScheme(
    primary = GreenPrimary,
    secondary = GreenSecondary,
    background = GreenLight,
    surface = CardSurface,
    onPrimary = OnPrimaryText,
    onBackground = GreenPrimary,
    onSurface = GreenPrimary
)

@Composable
fun DefinaaTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = CheatDayColorScheme,
        typography = Typography,
        content = content
    )
}