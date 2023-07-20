package com.amna.donutsapp.ui.theme.screens.homescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.amna.donutsapp.ui.theme.Card
import com.amna.donutsapp.ui.theme.Primary
import com.amna.donutsapp.ui.theme.TextPrimary
import com.amna.donutsapp.ui.theme.Typography
import com.amna.donutsapp.ui.theme.screens.customShadow
import com.amna.donutsapp.ui.theme.screens.homescreen.DonutUiState

@Composable
fun DonutCardItem(
    state: DonutUiState = DonutUiState(),
) {
    Box{

        Column(
            modifier = Modifier
                .zIndex(1f)
                .align(Alignment.Center)
                .padding(vertical = 20.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        )  {
            Image(
                painter = painterResource(id = state.image),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Text(
                text = state.name,
                color = TextPrimary,
                style = Typography.bodyMedium,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = state.price,
                color = Primary,
                style = Typography.bodyMedium,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .size(160.dp)
                .padding(top = 30.dp)
                .customShadow(RoundedShape.large)
                .clickable { true }
                .background(
                    color = Card,
                    shape = RoundedShape.large
                )
        )

    }
}


val RoundedShape = Shapes(
    large = RoundedCornerShape(
        topEnd = 20.dp,
        topStart = 20.dp,
        bottomEnd = 10.dp,
        bottomStart = 10.dp
    ),
    medium = RoundedCornerShape(20.dp),
    small = RoundedCornerShape(15.dp),
    extraSmall = RoundedCornerShape(10.dp),
    extraLarge = RoundedCornerShape(50.dp)

)