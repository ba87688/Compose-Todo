package com.example.composetodo.navigation

sealed class Screens (val route:String){
    object HomeScreen: Screens("HomePage")
    object ToDoListScreen: Screens("ToDoList")
}