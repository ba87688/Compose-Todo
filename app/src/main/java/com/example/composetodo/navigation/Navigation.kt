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
//        , arguments = listOf(navArgument(TODOLIST_ARGUMENT_KEY){
//            type= NavType.StringType
//            },
//                navArgument(TODOLIST_ARGUMENT_KEY2){
//                    type= NavType.StringType
//                })
//        ) {

//            Log.d("NEVER", "Navigate: ${it.arguments?.getString(TODOLIST_ARGUMENT_KEY)}")
//            Log.d("NEVER", "Navigate: ${it.arguments?.getString(TODOLIST_ARGUMENT_KEY2)}")


//            LaunchedEffect(key1 = it ){
//                val item = navController.previousBackStackEntry?.savedStateHandle?.get<ToDoItem>("todoitem")
//                Log.d("NEVER", "Navigate: ${item?.name}")
//            }


//            val currentItemIndex = mainViewModel.currentItemIndex
////            Log.d("NEVER", "Navigate: $currentItem")
//
//            LaunchedEffect(key1 = currentItemIndex ){
//                if (currentItemIndex!=null){
//                    Log.d("NEVER ate", "Navigate: $currentItemIndex")
//                    val currentItem  = mainViewModel.getCurrentToDoItem(currentItemIndex)
//                    Log.d("NEVER ate", "Navigate: ${currentItem?.name}")
//
//
//                }
//            }


            ToDoDetail(mainViewModel)

        }


    }
}