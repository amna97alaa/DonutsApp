package com.amna.donutsapp.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.amna.donutsapp.ui.theme.Card
import com.amna.donutsapp.ui.theme.TextPrimary
import com.amna.donutsapp.ui.theme.Typography
import com.amna.donutsapp.ui.theme.screens.customShadow
import com.amna.donutsapp.ui.theme.screens.homescreen.components.RoundedShape

@Composable
fun CounterPart(
    onClickPlus: () -> Unit = {},
    onClickMinus: () -> Unit = {},
    quantity: String = "1",
) {

    Row(
        modifier = Modifier.padding(top = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ButtonCounter(
            text = "-",
            modifier = Modifier
                .size(45.dp)
                .customShadow(shape = RoundedShape.small)
                .background(color = Card)
                .clip(RoundedShape.small),
            onClick = onClickMinus
        )
        Box(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .size(45.dp)
                .customShadow(shape = RoundedShape.small)
                .background(color = Card)
                .clip(RoundedShape.small),
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = quantity,
                textAlign = TextAlign.Center,
                style = Typography.bodyLarge,
                color = TextPrimary
            )
        }
        ButtonCounter(
            text = "+", modifier = Modifier
                .size(45.dp)
                .customShadow(shape = RoundedShape.small)
                .background(color = Card)
                .clip(RoundedShape.small),
            onClick = onClickPlus
        )
    }
}