package com.farmani.masoud.funfacts.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.farmani.masoud.funfacts.data.UserDataUiEvents
import com.farmani.masoud.funfacts.data.UserInputScreenState

class UserInputViewModel : ViewModel() {

    var uiState = mutableStateOf(UserInputScreenState())

    fun onEvent(event: UserDataUiEvents) {
        when (event) {
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(userName = event.userName)
            }

            is UserDataUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(selectedAnimal = event.animalName)
            }
        }
    }

    fun hasValidState() = uiState.value.userName.trim().isNotEmpty()  and uiState.value.selectedAnimal.isNotEmpty()
}