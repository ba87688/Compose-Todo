package com.example.composetodo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.example.composetodo.navigation.Navigate
import com.example.composetodo.network.database.ToDoListDao
import com.example.composetodo.ui.theme.ComposeToDoTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
//    @Inject
//    lateinit var dao: ToDoListDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        lifecycleScope.launch {
//            withContext(Dispatchers.IO) {
//                var l = dao.getAllToDoItemsList()
//                Log.d("TAG", "onCreate: HOMMMMM ${l.get(0).name}")
//
//            }
//        }


        setContent {

            ComposeToDoTheme {

                var i = rememberNavController()
                Navigate(navController = i)
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