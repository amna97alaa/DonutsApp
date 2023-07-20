package com.amna.donutsapp.ui.theme.screens.detailsscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.amna.donutsapp.R

@Composable
fun ReturnIcon() {
    val imageVector = ImageVector.vectorResource(id = R.drawable.ic_back)
    Box(
        modifier = Modifier
            .size(35.dp)
            .clickable { true }
    ) {
        Image(
            imageVector = imageVector,
            contentDescription = "",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}