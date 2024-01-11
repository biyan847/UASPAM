package com.example.uaspam.Navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Home : Screen("home_screen")

    object Halaman : Screen("Halaman_home")
}