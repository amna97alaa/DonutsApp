package com.amna.donutsapp.ui.theme.screens.homescreen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.amna.donutsapp.ui.theme.navigation.BottomNavigationBar

private const val ROUTE = "Home"

fun NavController.navigateToHomeScreen(){
    navigate(ROUTE)
}

fun NavGraphBuilder.homeRoute() {
    composable(BottomNavigationBar.Home.route) { HomeScreen() }
}