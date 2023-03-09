package com.example.composetodo.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composetodo.models.ToDoItem
import com.example.composetodo.navigation.Screens
import com.example.composetodo.network.database.ToDoListDatabase
import com.example.composetodo.screens.screenelements.ToDoCard
import com.example.composetodo.viewmodels.ToDoListViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    i:NavHostController,
    gameViewModel: ToDoListViewModel = viewModel()

    ){
//    val f = gameViewModel.getAllList()

    Log.d("TAG", "HomeScreen: SHIT ")

    Scaf(i)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Scaf(i: NavHostController){
    val navController = rememberNavController()
    val r = LocalContext.current
    val composableScope = rememberCoroutineScope()
    Scaffold(
        topBar = { TopAppBar(title = {Text("Things To Do...")},backgroundColor = Color.White)  },
        floatingActionButtonPosition = FabPosition.Center,

        floatingActionButton = { FloatingActionButton(onClick = {
            Log.i("TAG", "Scaf: coming soon!")



            var db = ToDoListDatabase.getDatabase(r)
            var dao = db.toDoListDao()
            composableScope.launch {
                dao.insert(ToDoItem(false,"Kevin","Sorbo"))

                Log.d("INSIDE", "Scaf: success? ")
            }





//            i.navigate(Screens.ToDoListAddScreen.route)

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