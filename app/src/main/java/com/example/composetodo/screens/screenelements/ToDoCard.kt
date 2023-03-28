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
            val cardColor = when (item.topPriority) {
                    "low" -> Color.Green
                    "Med" -> Color.Yellow
                    else -> Color.Red
            }

            Card(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable {
                        mainViewModel.setCurrentItemIndex(index)
                        if (mainViewModel.isDialogShown == false) {
                            mainViewModel.onPurchaseClick()
                        }


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
                            .background(cardColor)
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
                        modifier = Modifier
                            .fillMaxWidth()
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
                                if (checked) {
                                    mainViewModel.update(item, true)

                                } else {
                                    mainViewModel.update(item, false)

                                }

                            }
                        )


                    }


                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    var list = mutableListOf<ToDoItem>()
//    ToDoCard(list)
}