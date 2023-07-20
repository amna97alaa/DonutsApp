package com.amna.donutsapp.ui.theme.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amna.donutsapp.ui.theme.Card
import com.amna.donutsapp.ui.theme.TextPrimary
import com.amna.donutsapp.ui.theme.Typography
import com.amna.donutsapp.ui.theme.inter
import com.amna.donutsapp.ui.theme.screens.homescreen.components.RoundedShape

@Composable
fun Button(text : String, modifier: Modifier = Modifier, onClick:() -> Unit, textColor: Color = TextPrimary, backgroundColor: Color = Card) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        modifier = modifier
            .height(54.dp)
            .fillMaxWidth(),
        shape = RoundedShape.extraLarge
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = inter,
                fontWeight = FontWeight.Medium
            ),
            color = textColor
        )
    }
}