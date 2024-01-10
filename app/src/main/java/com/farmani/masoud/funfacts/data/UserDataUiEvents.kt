package com.farmani.masoud.funfacts.data

sealed class UserDataUiEvents {

    data class UserNameEntered(val userName: String): UserDataUiEvents()
    data class AnimalSelected(val animalName: String): UserDataUiEvents()
}