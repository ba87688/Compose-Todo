package com.example.composetodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.composetodo.navigation.Navigate
import com.example.composetodo.network.database.ToDoListDao
import com.example.composetodo.repository.ToDoListRepository
import com.example.composetodo.ui.theme.ComposeToDoTheme
//import com.example.composetodo.viewmodels.ToDoListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        var factoryModel = ToDoListViewModelFactory(this.application,null, rep,this)


//        lifecycleScope.launch {
//            withContext(Dispatchers.IO) {
////                var l = dao.getAllToDoItemsList()
//                var l = rep.getToDoListItemsFromDB().asLiveData()
//                Log.d("TAG", "onCreate: HOMMMMM $l")
//
//            }
//        }


        setContent {

            ComposeToDoTheme {

                var i = rememberNavController()
                Navigate(navController = i)
//                Navigate(navController = i,factoryModel)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeToDoTheme {
        Greeting("Android")
    }
}