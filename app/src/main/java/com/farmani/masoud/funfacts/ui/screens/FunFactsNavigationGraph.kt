package com.farmani.masoud.funfacts.ui.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.farmani.masoud.funfacts.ui.UserInputViewModel

@Composable
fun FunFactsNavigationGraph(userInputViewModel: UserInputViewModel = viewModel()) {
    // with the help of this, we can remember the last state of our navigation Host
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.USER_INPUT_SCREEN,
    ) {
        // Inside this scope we can pass all composable screens we want to keep
        // we use composable() to add one screen into our navHost
        composable(Routes.USER_INPUT_SCREEN) {
            UserInputScreen(userInputViewModel) {
                val userName = userInputViewModel.uiState.value.userName
                val animalName = userInputViewModel.uiState.value.selectedAnimal
                navController.navigate("${Routes.WELCOME_SCREEN}/$userName/$animalName")
            }
        }

        composable(
            route = "{${Routes.WELCOME_SCREEN}}/{userName}/{animalName}",
            arguments = listOf(
                navArgument(name = "userName") { type = NavType.StringType },
                navArgument(name = "animalName") { type = NavType.StringType },
            )
        ) {
            WelcomeScreen(
                it.arguments?.getString("userName")!!,
                it.arguments?.getString("animalName")!!
            )
        }
    }
}