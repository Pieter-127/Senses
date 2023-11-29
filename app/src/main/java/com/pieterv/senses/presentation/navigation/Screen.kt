package com.pieterv.senses.presentation.navigation

sealed class Screen(
    val route: String,
) {
    object LoginScreen : Screen("main_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
