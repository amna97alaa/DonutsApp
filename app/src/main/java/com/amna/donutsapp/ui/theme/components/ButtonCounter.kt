package com.amna.donutsapp.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.amna.donutsapp.ui.theme.Card
import com.amna.donutsapp.ui.theme.TextPrimary
import com.amna.donutsapp.ui.theme.Typography

@Composable
fun ButtonCounter(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    text: String,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    IconButton(
        onClick = onClick,
        modifier = modifier.background(
            color = if (isPressed) TextPrimary else Color.Transparent,
        ),
        interactionSource = interactionSource
    ) {
        Text(text = text,
            modifier = Modifier.padding(horizontal = 16.dp),
            style = Typography.bodyLarge,
            color = if (isPressed) Card else TextPrimary )
    }
}
