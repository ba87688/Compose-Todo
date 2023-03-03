package com.example.composetodo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composetodo.screens.HomeScreen
import com.example.composetodo.screens.ToDoAddToList
import com.example.composetodo.screens.ToDoDetail

@Composable
fun Navigate(navController: NavHostController){

    NavHost(navController = navController, startDestination = Screens.HomeScreen.route ) {
        composable(route = Screens.HomeScreen.route) {
            HomeScreen(navController)

        }

        composable(route = Screens.ToDoListAddScreen.route) {
            ToDoAddToList()


        }
        composable(route = Screens.ToDoListDetail.route) {
            ToDoDetail()

        }

    }
}