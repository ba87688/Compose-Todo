package com.example.composetodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.composetodo.navigation.Navigate
import com.example.composetodo.network.database.ToDoListDao
import com.example.composetodo.repository.ToDoListRepository
import com.example.composetodo.ui.theme.ComposeToDoTheme
import com.example.composetodo.viewmodels.MainViewModel
//import com.example.composetodo.viewmodels.ToDoListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        setContent {

            ComposeToDoTheme {
                val mainViewModel = hiltViewModel<MainViewModel>()

                var i = rememberNavController()
                Navigate(navController = i, mainViewModel)
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
    }
}
//
//@Composable
//fun RadioButtonSample() {
//    val radioOptions = listOf("High", "Med", "Low")
//    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1] ) }
//    Row {
//        radioOptions.forEach { text ->
//            Row(
//                Modifier.selectable(
//                        selected = (text == selectedOption),
//                        onClick = {
//                            onOptionSelected(text)
//                        }
//                    )
//                    .padding(horizontal = 16.dp)
//            ) {
//                RadioButton(
//                    selected = (text == selectedOption),
//                    onClick = { onOptionSelected(text) }
//                )
//                Text(
//                    text = text,
//                    style = MaterialTheme.typography.body1.merge(),
//                    modifier = Modifier.padding(start = 16.dp, top = 9.dp)
//                )
//            }
//        }
//    }
//}