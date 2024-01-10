package com.farmani.masoud.funfacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.farmani.masoud.funfacts.data.UserDataUiEvents
import com.farmani.masoud.funfacts.data.UserInputScreenState
import com.farmani.masoud.funfacts.ui.screens.FunFactsNavigationGraph
import com.farmani.masoud.funfacts.ui.screens.Routes
import com.farmani.masoud.funfacts.ui.screens.UserInputScreen
import com.farmani.masoud.funfacts.ui.screens.WelcomeScreen
import com.farmani.masoud.funfacts.ui.theme.FunFactsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            FunFactsTheme {
                FunFactsApp()
            }
        }
    }

    @Composable
    fun FunFactsApp() {
        FunFactsNavigationGraph()
    }
}


