package com.amna.donutsapp.ui.theme.navigation

import com.amna.donutsapp.R

sealed class BottomNavigationBar(
    val route: String,
    val title: String,
    val icon: Int,
    val selectedIcon: Int,
) {
    object Home : BottomNavigationBar(
        route = "Home",
        title = "Home",
        icon = R.drawable.ic_home,
        selectedIcon = R.drawable.ic_home_selected
    )

    object Favorite : BottomNavigationBar(
        route = "Favorite",
        title = "Favorite",
        icon = R.drawable.ic_heart_bottom_nav,
        selectedIcon = R.drawable.ic_heart_selected
    )

    object Notification : BottomNavigationBar(
        route = "Notification",
        title = "Notification",
        icon = R.drawable.ic_notification,
        selectedIcon = R.drawable.ic_notification_selected
    )

    object Cart : BottomNavigationBar(
        route = "Cart",
        title = "Cart",
        icon = R.drawable.ic_buy,
        selectedIcon = R.drawable.ic_buy_selected
    )

    object Profile : BottomNavigationBar(
        route = "Profile",
        title = "Profile",
        icon = R.drawable.ic_profile,
        selectedIcon = R.drawable.ic_profile_selected
    )

}