package com.amna.donutsapp.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amna.donutsapp.LocalNavigationProvider
import com.amna.donutsapp.R
import com.amna.donutsapp.ui.theme.Card
import com.amna.donutsapp.ui.theme.OnSecondary
import com.amna.donutsapp.ui.theme.Primary
import com.amna.donutsapp.ui.theme.Secondary
import com.amna.donutsapp.ui.theme.TextPrimary
import com.amna.donutsapp.ui.theme.inter
import com.amna.donutsapp.ui.theme.screens.homescreen.navigateToHomeScreen

@Composable
fun OnBoardingNavigate() {
    val navController = LocalNavigationProvider.current

    OnBoardingScreen(
        onClickGetStart = navController::navigateToHomeScreen
    )
}

@Preview(showSystemUi = true)
@Composable
fun OnBoardingScreen(onClickGetStart: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(OnSecondary)
    ) {
        Box() {
            Image(
                painter = painterResource(id = R.drawable.donut_purple),
                modifier = Modifier
                    .size(186.dp)
                    .align(Alignment.TopStart)
                    .padding(top = 0.dp, end = 18.dp, bottom = 40.dp),
                contentDescription = "",
            )

            Image(
                painter = painterResource(id = R.drawable.donut_group),
                contentDescription = "",
                modifier = Modifier
                    .height(350.dp)
                    .fillMaxWidth()
                    .rotate(16.18f)
                    .offset(40.dp, 10.dp)
                    .scale(1.4f, 1.4f)
                    .padding(top = 100.dp)
                    .align(Alignment.Center),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.donutpink_big),
                modifier = Modifier
                    .width(210.dp)
                    .height(200.dp)
                    .align(Alignment.TopEnd)
                    .scale(1.1f, 1.1f)
                    .padding(top = 24.dp, end = 20.dp),
                contentDescription = "",
                contentScale = ContentScale.Fit
            )
        }
        Box(modifier = Modifier.padding(top = 280.dp, start = 8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.donutpink_small),
                modifier = Modifier
                    .width(94.dp)
                    .height(70.dp)
                    .layoutId("small donut"),
                contentDescription = "",
                contentScale = ContentScale.Fit
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)

        ) {
            Image(
                painter = painterResource(id = R.drawable.half_donut),
                contentDescription = "",
                modifier = Modifier
                    .width(209.dp)
                    .height(165.dp)
                    .rotate(8f)
                    .align(Alignment.CenterEnd)
                    .offset(100.dp, 90.dp),
                contentScale = ContentScale.Crop
            )
        }

        Text(
            text = "Gonuts\n" +
                    "with\n" +
                    "Donuts",
            modifier = Modifier
                .padding(start = 30.dp, top = 200.dp)
                .align(Alignment.CenterStart),
            textAlign = TextAlign.Start,
            style = TextStyle(
                color = Primary,
                fontSize = 42.sp,
                fontFamily = inter,
                fontWeight = FontWeight.Bold
            )
        )

        Text(
            text = "Gonuts with Donuts is a Sri Lanka\n" +
                    "dedicated food outlets for specialize\n" +
                    "manufacturing of Donuts in Colombo, \n" +
                    "Sri Lanka.",
            modifier = Modifier
                .padding(start = 30.dp, top = 420.dp)
                .align(Alignment.CenterStart),
            textAlign = TextAlign.Start,
            style = TextStyle(
                color = Secondary,
                fontSize = 14.sp,
                fontFamily = inter,
                fontWeight = FontWeight.Medium
            )
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        ) {
            Button(
                onClick = onClickGetStart,
                modifier = Modifier
                    .height(65.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                colors = ButtonDefaults.buttonColors(Card),
                enabled = true
            ) {
                Text(
                    text = "Get Started",
                    style = TextStyle(
                        color = TextPrimary,
                        fontSize = 18.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
        }
    }
}