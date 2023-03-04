package com.example.composetodo.screens

import android.graphics.drawable.Drawable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsProperties.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composetodo.Greeting
import com.example.composetodo.R
import com.example.composetodo.navigation.Screens
import com.example.composetodo.ui.theme.ComposeToDoTheme

@Composable
fun ToDoAddToList(navController: NavHostController) {
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
        TextFieldWithOutline()
        Text(text = "priority...")
        MyUI()

        Button(
            onClick = {

                      navController.navigate(Screens.ToDoListDetail.passString("ji","xin"))
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
    val radioOptions = listOf("High", "Medium", "Low")

    var selectedItem by remember {
        mutableStateOf(radioOptions[0])
    }

    Row(modifier = Modifier.selectableGroup()) {

        radioOptions.forEach { label ->
            Row(
                modifier = Modifier
                    .height(56.dp)
                    .selectable(
                        selected = (selectedItem == label),
                        onClick = { selectedItem = label },
                        role = androidx.compose.ui.semantics.Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    modifier = Modifier.padding(end = 16.dp),
                    selected = (selectedItem == label),
                    onClick = null // null recommended for accessibility with screen readers
                )
                Text(text = label)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}