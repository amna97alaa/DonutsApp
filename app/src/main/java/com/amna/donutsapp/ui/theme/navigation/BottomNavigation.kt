package com.amna.donutsapp.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.amna.donutsapp.ui.theme.Black_30
import com.amna.donutsapp.ui.theme.Card
import com.amna.donutsapp.ui.theme.Primary
import com.amna.donutsapp.ui.theme.navigation.BottomNavigationBar

@Composable
fun BottomNavigation(navController: NavHostController){
    val screens = listOf(
        BottomNavigationBar.Home,
        BottomNavigationBar.Favorite,
        BottomNavigationBar.Notification,
        BottomNavigationBar.Cart,
        BottomNavigationBar.Profile
    )

    val navStackByEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackByEntry?.destination

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(86.dp)
            .customShadow(RectangleShape)
            .background(color = Card),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}


@Composable
private fun RowScope.AddItem(
    screen: BottomNavigationBar,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

    NavigationBarItem(
        icon = {
            Icon(
                painter = painterResource(id = if (isSelected) screen.selectedIcon else screen.icon),
                contentDescription = screen.title,
                tint = Primary
            )
        },
        selected = isSelected,
        colors = NavigationBarItemDefaults.colors(
            indicatorColor = Card,
        ),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    )
}

@Stable
fun Modifier.customShadow(shape: Shape) = then(
    this.shadow(
        elevation = 10.dp,
        shape = shape,
        ambientColor = Black_30,
        spotColor = Black_30
    )
)