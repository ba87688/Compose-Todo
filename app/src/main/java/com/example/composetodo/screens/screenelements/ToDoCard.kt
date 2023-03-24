package com.example.composetodo.screens.screenelements

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composetodo.Greeting
import com.example.composetodo.models.ToDoItem
import com.example.composetodo.navigation.Screens
import com.example.composetodo.ui.theme.ComposeToDoTheme
import com.example.composetodo.viewmodels.MainViewModel

@Composable
fun ToDoCard(
    list: List<ToDoItem>,
    i: NavHostController,
    mainViewModel: MainViewModel
) {

    var nav = i
    LazyColumn() {

        itemsIndexed(list) { index, item ->

            Card(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable {
                        Log.d("TAGNEVER", "ToDoCard: $index")
                        mainViewModel.setCurrentItemIndex(index)
                        if (mainViewModel.isDialogShown == false) {
                            Log.d("GANG GANG", "Scaf: it is FLASEEEEEEEE")
                            mainViewModel.onPurchaseClick()
                        }
//                        nav.currentBackStackEntry?.savedStateHandle?.set(
//                            key = "todoitem",
//                            value = item
//                        )
//                        nav.navigate(Screens.ToDoListDetail.route)


                    },
                elevation = 20.dp
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp)
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(Color.Red)
                    )
                    Text(modifier= Modifier.weight(2f),
                        text = item.name)
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        modifier= Modifier.weight(6f),
                        text = item.description,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 13.sp
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .weight(1f),
                        horizontalArrangement = Arrangement.End

                    ) {
                        var checked by remember {
                            mutableStateOf(item.done)
                        }

                        Checkbox(
                            checked = checked,
                            onCheckedChange = { checked_ ->
                                checked = checked_

                                Log.d("GGGGGGGGGGGG", "ToDoCard: $checked")
                                if (checked) {
                                    mainViewModel.update(item, true)
                                } else {
                                    mainViewModel.update(item, false)

                                }
                                Log.d("GGGGGGGGGGGG3", "ToDoCard: ${item.done}")

                            }
                        )


                    }


                }
            }
        }
//        items(list) { item ->
//
//
//            Card(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(10.dp)
//                    .clickable {
//
//                        nav.currentBackStackEntry?.savedStateHandle?.set(
//                            key = "todoitem",
//                            value = item
//                        )
//                        nav.navigate(Screens.ToDoListDetail.route)
//
//
//                    },
//                elevation = 20.dp
//            ) {
//                Row(
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Row(
//                        horizontalArrangement = Arrangement.Center
//                    ) {
//                        Box(
//                            modifier = Modifier
//                                .padding(start = 10.dp, end = 10.dp)
//                                .size(24.dp)
//                                .clip(CircleShape)
//                                .background(Color.Red)
//                        )
//                        Text(text = item.name)
//                        Text(text = item.description)
//                    }
//
//
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.End
//                    ) {
//
//
//                        Checkbox(
//                            checked = true,
//                            onCheckedChange = { }
//                        )
//
//                    }
//
//                }
//            }
//
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    var list = mutableListOf<ToDoItem>()
//    ToDoCard(list)
}