package com.example.composetodo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composetodo.screens.HomeScreen
import com.example.composetodo.screens.ToDoDetail

@Composable
fun Navigate(navController: NavHostController){

    NavHost(navController = navController, startDestination = Screens.HomeScreen.route ) {
        composable(route = Screens.HomeScreen.route) {
            HomeScreen(navController)

        }
        composable(route = Screens.ToDoListScreen.route) {
            ToDoDetail()

        }

    }
}