package com.example.composetodo.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composetodo.screens.HomeScreen
import com.example.composetodo.screens.ToDoAddToList
import com.example.composetodo.screens.ToDoDetail
import com.example.composetodo.viewmodels.MainViewModel

@Composable
fun Navigate(navController: NavHostController, mainViewModel: MainViewModel){

    NavHost(navController = navController, startDestination = Screens.HomeScreen.route ) {
        composable(route = Screens.HomeScreen.route) {
            HomeScreen(navController, mainViewModel)
        }
        composable(route = Screens.ToDoListAddScreen.route) {
            ToDoAddToList(navController, mainViewModel)
        }
        composable(route = Screens.ToDoListDetail.route){
            ToDoDetail(mainViewModel)
        }


    }
}