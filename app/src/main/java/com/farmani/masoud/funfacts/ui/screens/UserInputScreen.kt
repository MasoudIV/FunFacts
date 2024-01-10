package com.farmani.masoud.funfacts.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.farmani.masoud.funfacts.R
import com.farmani.masoud.funfacts.data.UserDataUiEvents
import com.farmani.masoud.funfacts.ui.AnimalCard
import com.farmani.masoud.funfacts.ui.ButtonComponent
import com.farmani.masoud.funfacts.ui.TextComponent
import com.farmani.masoud.funfacts.ui.TextFieldComponent
import com.farmani.masoud.funfacts.ui.TopBar
import com.farmani.masoud.funfacts.ui.UserInputViewModel
import com.farmani.masoud.funfacts.ui.theme.FunFactsTheme

@Composable
fun UserInputScreen(
    userInputViewModel: UserInputViewModel,
    showDetailScreenCallback : () -> Unit
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
               TopBar(text = "Hi There \uD83D\uDE0A")

               TextComponent(textValue = "Let's learn about You !", textSize = 24.sp)

               Spacer(modifier = Modifier.size(20.dp))

               TextComponent(
                   textValue = "Let's learn about You ! Let's learn about You ! Let's learn about You !",
                   textSize = 18.sp
               )

               Spacer(modifier = Modifier.size(60.dp))

               TextComponent(textValue = "Name", textSize = 18.sp)

               Spacer(modifier = Modifier.size(10.dp))

               TextFieldComponent(
                   currentValue = userInputViewModel.uiState.value.userName,
                   onTextChanged = { userName ->
                       userInputViewModel.onEvent(UserDataUiEvents.UserNameEntered(userName))
                   }
               )

               Spacer(modifier = Modifier.size(20.dp))

               TextComponent(textValue = "What do you like", textSize = 18.sp)

               Row(
                   modifier = Modifier
                       .fillMaxWidth(),
                   verticalAlignment = Alignment.CenterVertically,
                   horizontalArrangement = Arrangement.Center
               ) {
                   AnimalCard(
                       imageId = R.drawable.cat,
                       onAnimalSelected = { animalName ->
                           userInputViewModel.onEvent(UserDataUiEvents.AnimalSelected(animalName))
                       },
                       isSelected = userInputViewModel.uiState.value.selectedAnimal == "Cat"
                   )
                   AnimalCard(
                       imageId = R.drawable.dog,
                       onAnimalSelected = { animalName ->
                           userInputViewModel.onEvent(UserDataUiEvents.AnimalSelected(animalName))
                       },
                       isSelected = userInputViewModel.uiState.value.selectedAnimal == "Dog"
                   )
               }

               if (userInputViewModel.hasValidState()) {
                   Spacer(modifier = Modifier.weight(1f))

                   ButtonComponent(onClickEvent = showDetailScreenCallback)

                   Spacer(modifier = Modifier.weight(.1f))
               }
           }

       }
   }
}

@Preview
@Composable
fun UserInputScreenPreview() {
    FunFactsTheme {
        UserInputScreen(
            userInputViewModel = viewModel()
        ){}
    }
}

