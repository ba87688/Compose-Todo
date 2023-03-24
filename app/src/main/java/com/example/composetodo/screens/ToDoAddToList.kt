package com.example.composetodo.screens

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
fun ToDoAddToList(navController: NavHostController,
                  mainViewModel: MainViewModel) {

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
            ){

        val offset = Offset(5.0f, 10.0f)

        Text(
            text = "nameOf",
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
            label = { Text(text = "Label is...")}
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
            label = { Text(text = "Label is...")}
        )
        Text(text = "priority...")


        //add priority option shere.

        var list = listOf("High", "Med", "Low")
        RadioButtonSample(list)

//        MyUI(radioOptions,selectedItem)

        Button(
            onClick = {
                val name = nameText.text
                val describeTask = descriptionText.text


                val toDoItem = ToDoItem("low",name,describeTask,false)
                mainViewModel.addToDoItem(toDoItem)


                navController.navigate(Screens.HomeScreen.route)
        }, modifier = Modifier.padding(8.dp)) {
            Row {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(text = " Add")
            }
        }
    }







}

@Composable
fun TextFieldWithOutline(
){
    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }
    OutlinedTextField(
        value = text,
        modifier = Modifier.padding(bottom = 20.dp),
        onValueChange = {
            text = it
        },
        label = { Text(text = "Label is...")}
    )







}

@Composable
fun MyUI() {
//
    val radioOptions = listOf("High", "Medium", "Low")

    val selectedItem by remember {
        mutableStateOf(radioOptions[0])
    }
    Row(modifier = Modifier.selectableGroup()) {

        radioOptions.forEach { label ->
            Row(
                modifier = Modifier
                    .height(56.dp)
//                    .selectable(
//                        selected = (selectedItem == label)
//                        onClick = { selectedItem = label },
//                        role = androidx.compose.ui.semantics.Role.RadioButton
//                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    modifier = Modifier.padding(end = 16.dp),
                    selected = (selectedItem == label),
                    onClick = null // null recommended for accessibility with screen readers
                )
                var color:Color
                when(label){
                    "High" -> color = Color.Red
                    "Medium" -> color = Color.Blue
                    else -> color =Color.Green

                }
                Text(text = label, color = color)

            }
        }
    }












}
@Composable
fun RadioButtonSample(list:List<String>):String {
    val radioOptions = list
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1] ) }
    Row {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.body1.merge(),
                    modifier = Modifier.padding(start = 16.dp, top = 9.dp)
                )
            }
        }
    }
    return ""
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {



}