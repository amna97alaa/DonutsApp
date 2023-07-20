package com.amna.donutsapp.ui.theme.screens.detailsscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.amna.donutsapp.LocalNavigationProvider
import com.amna.donutsapp.R
import com.amna.donutsapp.ui.theme.Card
import com.amna.donutsapp.ui.theme.OnSecondary
import com.amna.donutsapp.ui.theme.Primary
import com.amna.donutsapp.ui.theme.TextPrimary
import com.amna.donutsapp.ui.theme.TextSecondary60
import com.amna.donutsapp.ui.theme.Typography
import com.amna.donutsapp.ui.theme.components.BottomSheet
import com.amna.donutsapp.ui.theme.components.Button
import com.amna.donutsapp.ui.theme.components.ButtonIcon
import com.amna.donutsapp.ui.theme.components.CounterPart
import com.amna.donutsapp.ui.theme.components.ScaffoldApp
import com.amna.donutsapp.ui.theme.inter
import com.amna.donutsapp.ui.theme.screens.customShadow
import com.amna.donutsapp.ui.theme.screens.homescreen.components.RoundedShape

@Preview(showSystemUi = true)
@Composable
fun DetailsScreen(viewModel: DetailsViewModel = hiltViewModel(),) {

    val state by viewModel.state.collectAsState()
    val navController = LocalNavigationProvider.current
    DetailsContent(
        state = state,
        onClickBack = navController::popBackStack,
        increaseQuantity = viewModel::increaseQuantity,
        decreaseQuantity = viewModel::decreaseQuantity,
    )}

@Composable
fun DetailsContent(
    state: DetailsUiState,
    onClickBack: () -> Unit,
    increaseQuantity: () -> Unit,
    decreaseQuantity: () -> Unit,
){
    ScaffoldApp(content = {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = OnSecondary)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .height(340.dp)
                    .fillMaxWidth()
            ) {

                Image(
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.donutpink_card),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                ButtonIcon(
                    modifier = Modifier.align(Alignment.TopStart),
                    onClick = onClickBack,
                    iconTint = Primary,
                    painter = painterResource(id = R.drawable.ic_back)
                )
            }
            Box(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .zIndex(6f)
                    .offset(x = (-20).dp, y = (-80).dp)
            )
            {
                favIcon()
            }

            BottomSheet(modifier = Modifier.align(Alignment.BottomCenter)) {
                Text(
                    text = "Strawberry Wheel",
                    modifier = Modifier.padding(vertical = 35.dp),
                    color = Primary,
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight.SemiBold
                    )
                )

                Text(
                    text = "About Gonut",
                    modifier = Modifier.padding(bottom = 16.dp),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight.Medium
                    ),
                    color = TextPrimary
                )
                Text(
                    text = "These soft, cake-like Strawberry Frosted Donuts feature fresh strawberries and a delicious fresh strawberry glaze frosting. Pretty enough for company and the perfect treat to satisfy your sweet tooth.",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight.Normal
                    ),
                    color = TextSecondary60
                )
                Text(
                    text = "Quantity",
                    modifier = Modifier.padding(top = 16.dp),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight.Medium
                    ),
                    color = TextPrimary
                )
                CounterPart(
                    onClickPlus = increaseQuantity,
                    onClickMinus = decreaseQuantity,
                    quantity = if (state.donutOffers.quantity > 16) "0" else state.donutOffers.quantity.toString()
                )
                Row(
                    modifier = Modifier.align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "£${state.donutOffers.newPrice}",
                        style = TextStyle(
                            fontSize = 30.sp,
                            fontFamily = inter,
                            fontWeight = FontWeight.SemiBold
                        ),
                        color = TextPrimary,
                    )
                    Button(
                        text = "Add to Cart",
                        onClick = {},
                        backgroundColor = Primary,
                        textColor = Card,
                        modifier = Modifier.width(200.dp)
                    )

                }
            }
        }
    })
}


@Composable
fun favIcon(){
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
                .size(45.dp)
                .customShadow(shape = RoundedShape.small)
                .background(shape = RoundedShape.small, color = Card)
                .clip(RoundedShape.small),
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