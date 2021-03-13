package com.example.androiddevchallenge.ui.theme

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.androiddevchallenge.R

@Composable
fun SearchIcon(){
    Icon(painter = painterResource(id = R.drawable.ic_baseline_search_24), contentDescription = "Search icon")
}

@Composable
fun SpaIcon(){
    Icon(painter = painterResource(id = R.drawable.ic_baseline_spa_24), contentDescription = "Spa icon")
}

@Composable
fun AccountCircleIcon(){
    Icon(painter = painterResource(id = R.drawable.ic_baseline_account_circle_24), contentDescription = "Account icon")
}

@Composable
fun PlayArrowIcon(){
    Icon(painter = painterResource(id = R.drawable.ic_baseline_play_arrow_24), contentDescription = "Play icon")
}