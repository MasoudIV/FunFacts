package com.farmani.masoud.funfacts.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.farmani.masoud.funfacts.ui.FactCard
import com.farmani.masoud.funfacts.ui.TextComponent
import com.farmani.masoud.funfacts.ui.TextWithShadow
import com.farmani.masoud.funfacts.ui.TopBar
import com.farmani.masoud.funfacts.ui.theme.FunFactsTheme

@Composable
fun WelcomeScreen(
    userName: String = "",
    selectedAnimal: String = "",

) {


    FunFactsTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                TopBar(text = "Welcome $userName \uD83D\uDE0D")

                TextComponent(textValue = "Thank You! for sharing your data", textSize = 24.sp)

                Spacer(modifier = Modifier.size(60.dp))

                val selectedAnimalEmoji =
                    if (selectedAnimal == "Cat") "\uD83D\uDE3A" else " \uD83D\uDC36"
                val personText = "You are a $selectedAnimal Lover$selectedAnimalEmoji."
                TextWithShadow(textValue = personText, textSize = 24.sp)

                FactCard(selectedAnimal)
            }
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    FunFactsTheme {
        WelcomeScreen("Masoud", "Dog")
    }
}