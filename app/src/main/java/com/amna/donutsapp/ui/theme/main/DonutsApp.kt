package com.amna.donutsapp

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.amna.donutsapp.ui.theme.DonutsAppTheme
import com.amna.donutsapp.ui.theme.navigation.GoNutsNavGraph

val LocalNavigationProvider = staticCompositionLocalOf<NavHostController> {
    error("No navigation host controller provided.")
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DoNutsApp() {
    CompositionLocalProvider(LocalNavigationProvider provides rememberNavController()) {
        DonutsAppTheme() {
            GoNutsNavGraph()
        }

    }
}