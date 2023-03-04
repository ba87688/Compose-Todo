package com.example.composetodo.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composetodo.models.ToDoItem
import com.example.composetodo.models.ToDoItemArgType
import com.example.composetodo.screens.HomeScreen
import com.example.composetodo.screens.ToDoAddToList
import com.example.composetodo.screens.ToDoDetail
import com.google.gson.Gson

@Composable
fun Navigate(navController: NavHostController){

    NavHost(navController = navController, startDestination = Screens.HomeScreen.route ) {
        composable(route = Screens.HomeScreen.route) {
            HomeScreen(navController)

        }

        composable(route = Screens.ToDoListAddScreen.route) {
            ToDoAddToList(navController)


        }
        composable(route = Screens.ToDoListDetail.route
        , arguments = listOf(navArgument(TODOLIST_ARGUMENT_KEY){
            type= NavType.StringType
            },
                navArgument(TODOLIST_ARGUMENT_KEY2){
                    type= NavType.StringType
                })
        ) {
            Log.d("NEVER", "Navigate: ${it.arguments?.getString(TODOLIST_ARGUMENT_KEY)}")
            Log.d("NEVER", "Navigate: ${it.arguments?.getString(TODOLIST_ARGUMENT_KEY2)}")
            ToDoDetail()

        }


    }
}