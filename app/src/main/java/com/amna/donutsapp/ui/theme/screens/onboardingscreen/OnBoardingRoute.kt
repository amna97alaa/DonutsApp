package com.amna.donutsapp.ui.theme.screens.onboardingscreen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.amna.donutsapp.ui.theme.screens.OnBoardingNavigate
import com.amna.donutsapp.ui.theme.screens.OnBoardingScreen

private const val ROUTE = "OnBoarding"

fun NavController.navigateToOnBoarding() {
    navigate(ROUTE)
}

fun NavGraphBuilder.onBoardingRoute() {
    composable(route = ROUTE) {
        OnBoardingNavigate()
    }
}