package com.amna.donutsapp.ui.theme.screens.homescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.amna.donutsapp.R
import com.amna.donutsapp.ui.theme.Background

@Composable
fun FavoriteIcon() {

    val isFavorite = remember { mutableStateOf(false) }

    val imageVector = if (isFavorite.value) {
        ImageVector.vectorResource(id = R.drawable.ic_heart_filled)
    } else {
        ImageVector.vectorResource(id = R.drawable.ic_heart)
    }

    Row(
        modifier = Modifier.padding(8.dp)

    ) {
        val imageVector = imageVector
        Box(
            modifier = Modifier
                .size(35.dp)
                .background(shape = RoundedShape.medium, color = Background)
                .clip(RoundedShape.medium)
        ) {
            Image(
                imageVector = imageVector,
                contentDescription = "",
                modifier = Modifier.align(Alignment.Center).clickable(enabled = true){
                    isFavorite.value = !isFavorite.value
                }
            )
        }
    }
}