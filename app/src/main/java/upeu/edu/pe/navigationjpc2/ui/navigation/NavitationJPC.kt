package upeu.edu.pe.navigationjpc2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import upeu.edu.pe.navigationjpc2.ui.presentation.screens.CalcUPeU
import upeu.edu.pe.navigationjpc2.ui.presentation.screens.HomeScreen
import upeu.edu.pe.navigationjpc2.ui.presentation.screens.ProfileScreen
import upeu.edu.pe.navigationjpc2.ui.presentation.screens.SettingsScreen

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen() }
        composable("profile") { ProfileScreen() }
        composable("settings") { SettingsScreen() }
        composable("calc"){ CalcUPeU()}
    }
}