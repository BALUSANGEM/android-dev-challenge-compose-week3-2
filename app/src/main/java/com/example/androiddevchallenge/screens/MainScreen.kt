package com.example.androiddevchallenge.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.HOME_SCREEN
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.CardListRow
import com.example.androiddevchallenge.ui.components.RoundCardListRow
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.viewmodel.NavigationViewModel
import com.example.androiddevchallenge.viewmodel.SoothViewModel

@Composable
fun HomeScreen(){
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(ScrollState(0)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        TextField(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .height(56.dp)
                .fillMaxWidth(),
            value = "",
            onValueChange = { },
            label = { Text("Search") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_search_24),
                    contentDescription = "",
                    modifier= Modifier.size(18.dp),
                )
            }
        )
        Spacer(modifier = Modifier.height(24.dp))
        CardListRow()
        Spacer(modifier = Modifier.height(8.dp))
        RoundCardListRow()
        Spacer(modifier = Modifier.height(8.dp))
        RoundCardListRow()
    }
}
@Composable
fun MainScreen(
    navigationViewModel: NavigationViewModel,
    soothViewModel: SoothViewModel
) {
    Scaffold(
        bottomBar = {
            BottomNavigation{
                (0 until 2).forEach {
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_spa_24),
                                contentDescription = null,
                            )},
                        label = { Text("Home") },
                        selected = navigationViewModel.CURRENT_SCREEN == HOME_SCREEN,
                        onClick = {
                            navigationViewModel.goto(HOME_SCREEN, true)
                        }
                    )
                }
            }
        }
    ){
        HomeScreen()
    }
}

@Preview("Light Theme Homescreen", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewHomescreen() {
    MyTheme {
        MainScreen(NavigationViewModel(rememberNavController()), SoothViewModel())
    }
}

@Preview("Dark Theme Homescreen", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewHomescreen() {
    MyTheme(darkTheme = true){
        MainScreen(NavigationViewModel(rememberNavController()), SoothViewModel())
    }
}