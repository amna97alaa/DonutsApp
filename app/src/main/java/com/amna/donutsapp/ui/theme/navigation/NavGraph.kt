package com.amna.donutsapp.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.amna.donutsapp.LocalNavigationProvider
import com.amna.donutsapp.ui.theme.screens.detailsscreen.detailsRoute
import com.amna.donutsapp.ui.theme.screens.homescreen.homeRoute
import com.amna.donutsapp.ui.theme.screens.onboardingscreen.onBoardingRoute

@Composable
fun GoNutsNavGraph() {
    val navController = LocalNavigationProvider.current

    NavHost(navController = navController, startDestination = Screen.OnBoarding.rout) {
        homeRoute()
        composable(route = BottomNavigationBar.Favorite.route) { }
        composable(route = BottomNavigationBar.Notification.route) { }
        composable(route = BottomNavigationBar.Cart.route) { }
        composable(route = BottomNavigationBar.Profile.route) { }
        onBoardingRoute()
        detailsRoute()
    }

}

sealed class Screen(val rout: String) {
    object OnBoarding : Screen("OnBoarding")
}