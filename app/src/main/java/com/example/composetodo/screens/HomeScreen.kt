package com.example.composetodo.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Observer
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composetodo.models.ToDoItem
import com.example.composetodo.navigation.Screens
import com.example.composetodo.network.database.ToDoListDatabase
import com.example.composetodo.screens.screenelements.ToDoCard
import com.example.composetodo.viewmodels.MainViewModel
//import com.example.composetodo.viewmodels.ToDoListViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    i: NavHostController

){
//    val homeViewModel: ToDoListViewModel = viewModel(factory = factoryModel)
    val mainViewModel = hiltViewModel<MainViewModel>()


    Log.d("TAG", "HomeScreen: SHIT ")

    Scaf(i,mainViewModel)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Scaf(i: NavHostController, mainViewModel: MainViewModel){
    val navController = rememberNavController()
    val r = LocalContext.current
    val composableScope = rememberCoroutineScope()
    val lifecycleOwner = LocalLifecycleOwner.current

    //CURRENT elections
    var list = mutableListOf<ToDoItem>()



    var showWebView by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { TopAppBar(title = {Text("Things To Do...")},backgroundColor = Color.White)  },
        floatingActionButtonPosition = FabPosition.Center,

        floatingActionButton = { FloatingActionButton(onClick = {











            Log.i("TAG", "Scaf: coming soon!")


//
//            var db = ToDoListDatabase.getDatabase(r)
//            var dao = db.toDoListDao()
//            composableScope.launch {
//                dao.insert(ToDoItem(false,"Kevin","Sorbo"))
//
//                Log.d("INSIDE", "Scaf: success? ")
//            }





            i.navigate(Screens.ToDoListAddScreen.route)

        }) {
            Text(text = "+")
        }
        },
        drawerContent = { Text(text = "drawerContent") },
        content = {



            mainViewModel.currentToDoList.observe(lifecycleOwner, Observer { it ->
                val data = it.data
                if(data!=null){
                    Log.d("TAG", "Scaf: LIVE DATA IS NOT NULL ${data.get(0).name}")

                    list.clear()
                    list.addAll(data)
                    showWebView = true


                    mainViewModel.setButtonStatus(list)
                }
                else{
                    Log.d("TAG", "Scaf: LIVE DATA IS  NULL")

                }
            })

            val lifecycleOwner = LocalLifecycleOwner.current
            if(showWebView) {
                ToDoCard(list = list )

            }

        } ,

        )
}
