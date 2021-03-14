package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun RoundCardListRow(){
    Column(Modifier.padding(16.dp)){
        Text(
            text = "ALIGN YOUR BODY",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow {
            items(5){
                RoundCard()
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}

@Composable
fun RoundCard(){
    Column(
        Modifier
            .height(112.dp)
            .width(88.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
            modifier= Modifier.size(88.dp).clip(CircleShape),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Short mantras",
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.onBackground,
            textAlign = TextAlign.Center
        )
    }
}

@Preview("Light Theme RoundCardListRow", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewRoundCardListRow() {
    MyTheme {
        RoundCardListRow()
    }
}

@Preview("Dark Theme RoundCardListRow", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewRoundCardListRow() {
    MyTheme(darkTheme = true){
        RoundCardListRow()
    }
}