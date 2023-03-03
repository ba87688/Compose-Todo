package com.example.composetodo.navigation

sealed class Screens (val route:String){
    object HomeScreen: Screens("HomePage")
    object ToDoListAddScreen: Screens("ToDoListAdd")
    object ToDoListDetail: Screens("ToDoListDetail")
}