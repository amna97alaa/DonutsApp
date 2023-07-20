package com.amna.donutsapp.ui.theme.screens.homescreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.amna.donutsapp.ui.theme.TextPrimary
import com.amna.donutsapp.ui.theme.Typography
import androidx.compose.foundation.lazy.itemsIndexed
import com.amna.donutsapp.ui.theme.BabyBlue
import com.amna.donutsapp.ui.theme.OnSecondary
import com.amna.donutsapp.ui.theme.screens.homescreen.DonutOffersUiState

@Composable
fun OffersList(
    offers: List<DonutOffersUiState>,
    onClick: () -> Unit = {}
) {
    Text(
        text = "today_offers",
        color = TextPrimary,
        style = Typography.titleSmall,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp)
            .padding(horizontal = 16.dp)
    )
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        itemsIndexed(items = offers) { position, items ->
            val backgroundColor = if (position % 2 == 0) BabyBlue  else OnSecondary
            OffersCardItem(state =  items,backgroundColor, onClick = onClick)
        }
    }
}