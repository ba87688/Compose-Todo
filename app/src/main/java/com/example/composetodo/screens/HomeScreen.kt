package com.example.composetodo.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composetodo.models.ToDoItem
import com.example.composetodo.navigation.Screens
import com.example.composetodo.screens.screenelements.ToDoCard

@Composable
fun HomeScreen(i:NavHostController){


    Scaf(i)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Scaf(i: NavHostController){
    val navController = rememberNavController()

    Scaffold(
        topBar = { TopAppBar(title = {Text("Things To Do...")},backgroundColor = Color.White)  },
        floatingActionButtonPosition = FabPosition.Center,

        floatingActionButton = { FloatingActionButton(onClick = {
            Log.i("TAG", "Scaf: coming soon!")

            i.navigate(Screens.ToDoListAddScreen.route)

        }) {
            Text(text = "+")
        }
        },
        drawerContent = { Text(text = "drawerContent") },
        content = {
            var list = mutableListOf<ToDoItem>()
            var item1 = ToDoItem(false,"Ivan", "HO")
            var item2 = ToDoItem(false,"Kevin", "HO")
            list.add(item1)
            list.add(item2)
            ToDoCard(list)

        } ,

        )
}