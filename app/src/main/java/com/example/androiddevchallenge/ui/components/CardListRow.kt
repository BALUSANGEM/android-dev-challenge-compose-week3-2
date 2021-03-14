package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun CardListRow(){
    Column(Modifier.padding(16.dp)){
        Text(
            text = "FAVORITE COLLECTIONS",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow {
            items(5){
                Column {
                    Card()
                    Spacer(modifier = Modifier.height(8.dp))
                    Card()
                }
            }
        }
    }
}

@Composable
fun Card(){
    Row(
        Modifier
            .height(56.dp)
            .width(192.dp)
            .clip(MaterialTheme.shapes.small),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
            modifier= Modifier.size(56.dp),
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "Short mantras",
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.onBackground
        )
    }
}

@Preview("Light Theme CardListRow", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewCardListRow() {
    MyTheme {
        CardListRow()
    }
}

@Preview("Dark Theme CardListRow", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewCardListRow() {
    MyTheme(darkTheme = true){
        CardListRow()
    }
}