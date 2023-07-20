package com.amna.donutsapp.ui.theme.screens.homescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amna.donutsapp.ui.theme.Secondary
import com.amna.donutsapp.ui.theme.TextPrimary
import com.amna.donutsapp.ui.theme.TextSecondary60
import com.amna.donutsapp.ui.theme.Typography
import com.amna.donutsapp.ui.theme.inter
import com.amna.donutsapp.ui.theme.screens.customShadow
import com.amna.donutsapp.ui.theme.screens.homescreen.DonutOffersUiState

@Composable
fun OffersCardItem(
    state: DonutOffersUiState = DonutOffersUiState(),
    backgroundColor: Color = Secondary,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .height(280.dp)
    ) {
        Column(
            modifier = Modifier
                .customShadow(RoundedShape.medium)
                .clickable(onClick = onClick)
                .background(color = backgroundColor, shape = RoundedShape.medium)
                .width(160.dp)
                .wrapContentHeight()
                .padding(15.dp),
        ) {

            FavoriteIcon()

            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = state.title,
                color = TextPrimary,
                style = TextStyle(
                    fontFamily= inter,
                    fontSize = 16.sp ,
                    fontWeight= FontWeight.Medium
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = state.description,
                color = TextSecondary60,
                style = TextStyle(
                    fontFamily= inter,
                    fontSize = 12.sp ,
                    fontWeight= FontWeight.Normal
                ),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = state.oldPrice,
                    color = TextSecondary60,
                    style = TextStyle(
                        fontFamily= inter,
                        fontSize = 14.sp ,
                        fontWeight= FontWeight.SemiBold
                    ),
                    modifier = Modifier.padding(end = 5.dp),
                    textDecoration = TextDecoration.LineThrough
                )

                Text(
                    text = state.newPrice,
                    color = TextPrimary,
                    style = TextStyle(
                        fontFamily= inter,
                        fontSize = 22.sp ,
                        fontWeight= FontWeight.SemiBold
                    ),
                    modifier = Modifier.padding(end = 10.dp),
                )
            }
        }
        Image(
            painter = painterResource(id = state.imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .padding(start = 60.dp)
        )
    }
}
