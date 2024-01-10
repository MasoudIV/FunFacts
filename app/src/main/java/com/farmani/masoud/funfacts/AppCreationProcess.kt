package com.farmani.masoud.funfacts

/*
1. define FunFactsApp()
2. declare navController
3. call NavHost(navController, startDestination){}
4. Define some screens to put into NavHost
5. Create folder named "screens" inside ui package
6. Create UserInput and Welcome screen files
7. create kotlin singleton name "Routes" to hold screen names
8. add two routes to screens into navHost using composable(rout:String, args). also constants from
    Routes objects were used.
9. create "FunFactsNavigationGraph" and move all navController codes from FunFactsApp() into that
10. Declare Preview functions inside screen files
11. change screen composable to accept a parameter for navigation controller
12. Create "AppComponents" file inside ui package to declare ui composables and use in screens
13. Declare some Ui components like TopBar() , TextComponent() , ...
14. Add viewmodel dependency. androidx.lifecycle:lifecycle-viewmodel-compose
15. Create Class named "UserInputViewModel" that extends androidx.viewmodel
16. Create class named "UserInputScreenState" to hold state of the input screen
17. Create sealed class named "UserDataUiEvents" to handle entering username and selecting animal
and to update the sate
18. put classes from preceding two steps inside package "data"
19. declare function "onEvent" in UserInputViewModel to handle events and update uiState
20. Declare Composable "TextFieldComponent" inside AppComponents.kt
21. Add "TextFieldComponent" into UserInputScreen
22. Add "userInputViewModel" parameter to the UserInputScreen to trigger "onEvent()" when user enters
their name into text field
23. Create "AnimalCard" Composable
24. Implement "Animal Selection" event to update uiState and implement "is selected" for AnimalCard
25. Create "ButtonComponent" composable/ Show it only if UserInputViewModel is in a valid state
26. Implement navigation with passing arguments from UserInputScreen to WelcomeScreen
 */