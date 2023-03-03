package com.example.composetodo.screens.screenelements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetodo.Greeting
import com.example.composetodo.models.ToDoItem
import com.example.composetodo.ui.theme.ComposeToDoTheme

@Composable
fun ToDoCard(list: List<ToDoItem>) {

    LazyColumn() {

        items(list) { item ->


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable { },
                elevation = 20.dp
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(start = 10.dp, end = 10.dp)
                                .size(24.dp)
                                .clip(CircleShape)
                                .background(Color.Red)
                        )
                        Text(text = item.name)
                        Text(text = item.description)
                    }


                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {


                        Checkbox(
                            checked = true,
                            onCheckedChange = { }
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
}