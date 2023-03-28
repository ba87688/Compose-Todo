package com.example.composetodo.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composetodo.models.ToDoItem
import com.example.composetodo.navigation.Screens
import com.example.composetodo.screens.screenelements.CustomDialog
import com.example.composetodo.viewmodels.MainViewModel

@Composable
fun ToDoAddToList(
    navController: NavHostController,
    mainViewModel: MainViewModel
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val offset = Offset(5.0f, 10.0f)

        Text(
            text = "Adding a task:",
            style = TextStyle(
                color = Color.DarkGray,
                fontSize = 24.sp,
                shadow = Shadow(
                    color = Color.Gray, offset = offset, blurRadius = 3f
                )
            )
        )
        var nameText by remember {
            mutableStateOf(TextFieldValue(""))
        }

        //name field
        OutlinedTextField(
            value = nameText,
            modifier = Modifier.padding(bottom = 20.dp),
            onValueChange = {
                nameText = it
            },
            label = { Text(text = "Task title is...") }
        )

        var descriptionText by remember {
            mutableStateOf(TextFieldValue(""))
        }
        OutlinedTextField(
            value = descriptionText,
            modifier = Modifier.padding(bottom = 20.dp),
            onValueChange = {
                descriptionText = it
            },
            label = { Text(text = "Detail of task...") }
        )
        Text(text = "select priority...")
        //add priority option shere.

        val list = listOf("High", "Med", "Low")
//        val prio = RadioButtonSample(list)

        val (selected, setSelected) = remember { mutableStateOf(list.last()) }
        RadioButtonSample(list, selected, setSelected)
//        MyUI(radioOptions,selectedItem)

        Button(
            onClick = {
                val name = nameText.text
                val describeTask = descriptionText.text
                val prio = selected


                val toDoItem = ToDoItem(prio, name, describeTask, false)
                mainViewModel.addToDoItem(toDoItem)


                navController.navigate(Screens.HomeScreen.route)
            }, modifier = Modifier.padding(8.dp)
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(text = " Add Task")
            }
        }
    }


}


@Composable
fun RadioButtonSample(
    list: List<String>,
    selected: String,
    setSelected: (selected: String) -> Unit

) {
    val radioOptions = list

    var textPri by remember { mutableStateOf("") }
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1]) }
    Row {
        radioOptions.forEach { item ->
            Row(
                Modifier
                    .selectable(
                        selected = (item == selectedOption),
                        onClick = {
                            onOptionSelected(item)
                        }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = selected == item,
                    onClick = {
                        setSelected(item)
                    },
                    enabled = true
                )
                Text(
                    text = item,
                    style = MaterialTheme.typography.body1.merge(),
                    modifier = Modifier.padding(start = 16.dp, top = 9.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {


}