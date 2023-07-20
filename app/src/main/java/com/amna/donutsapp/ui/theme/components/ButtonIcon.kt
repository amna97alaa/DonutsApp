package com.amna.donutsapp.ui.theme.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import com.amna.donutsapp.ui.theme.TextPrimary

@Composable
fun ButtonIcon(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    painter: Painter,
    iconTint: Color = TextPrimary,
) {
    IconButton(
        onClick = onClick,
        modifier = modifier,
    ) {
        Icon(
            painter = painter,
            contentDescription = null,
            tint = iconTint
        )
    }
}
