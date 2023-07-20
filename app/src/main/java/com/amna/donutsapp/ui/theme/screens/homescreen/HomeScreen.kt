package com.amna.donutsapp.ui.theme.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.amna.donutsapp.LocalNavigationProvider
import com.amna.donutsapp.R
import com.amna.donutsapp.ui.theme.Background
import com.amna.donutsapp.ui.theme.OnSecondary
import com.amna.donutsapp.ui.theme.Primary
import com.amna.donutsapp.ui.theme.TextPrimary
import com.amna.donutsapp.ui.theme.TextSecondary60
import com.amna.donutsapp.ui.theme.inter
import com.amna.donutsapp.ui.theme.screens.BottomNavigation
import com.amna.donutsapp.ui.theme.screens.detailsscreen.navigateToDonutDetails
import com.amna.donutsapp.ui.theme.screens.homescreen.components.DonutsList
import com.amna.donutsapp.ui.theme.screens.homescreen.components.OffersList

@Preview(showSystemUi = true)
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    val navController = LocalNavigationProvider.current

    HomeContent(
        state = state,
        onClickDonutsOffers = navController::navigateToDonutDetails
    )
}

@Composable
fun HomeContent(
    state: HomeUiState,
    onClickDonutsOffers: () -> Unit = {},
) {
    val navController = LocalNavigationProvider.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    )
    {
        Column(
            modifier = Modifier
                .padding(start = 24.dp, top = 18.dp)
        ) {
            Text(
                modifier = Modifier.padding(bottom = 3.dp),
                text = "Let’s Gonuts!",
                textAlign = TextAlign.Start,
                style = TextStyle(
                    color = Primary,
                    fontSize = 30.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Text(
                text = "Order your favourite donuts from here",
                textAlign = TextAlign.Start,
                style = TextStyle(
                    color = TextSecondary60,
                    fontSize = 14.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight.Medium
                )
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 24.dp, top = 30.dp)
        ) {
            val imageVector = ImageVector.vectorResource(id = R.drawable.ic_search)
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(OnSecondary)
            ) {
                Image(
                    imageVector = imageVector,
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clickable { true }
                )
            }
        }

        Row(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 24.dp, top = 110.dp)
        ) {
            Text(
                text = "Today Offers",
                textAlign = TextAlign.Start,
                style = TextStyle(
                    color = TextPrimary,
                    fontSize = 20.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(bottom = 100.dp)
        ) {
            OffersList(offers = state.donutOffers, onClickDonutsOffers)
        }

        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 24.dp, top = 240.dp)
        ) {
            Row() {
                Text(
                    text = "Donuts",
                    textAlign = TextAlign.Start,
                    style = TextStyle(
                        color = TextPrimary,
                        fontSize = 20.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
        }
        Box(modifier = Modifier
            .align(Alignment.BottomStart)
            .padding(bottom = 60.dp)) {
            DonutsList(state.donut)

        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            BottomNavigation(navController = navController)
        }
    }
}