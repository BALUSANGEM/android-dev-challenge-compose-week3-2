package com.example.androiddevchallenge.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.LOGIN_SCREEN
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.viewmodel.NavigationViewModel

@Composable
fun WelcomeScreen(navigationViewModel: NavigationViewModel) {
    val backgroundResource =
        if (isSystemInDarkTheme()){
            R.drawable.ic_dark_welcome
        } else {
            R.drawable.ic_light_welcome
        }

    val logoResource =
        if (isSystemInDarkTheme()){
            R.drawable.ic_dark_logo
        } else {
            R.drawable.ic_light_logo
        }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = backgroundResource),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(start = 24.dp, end = 24.dp)
        ){
            Image(
                painter = painterResource(id = logoResource),
                contentDescription = "",
            )
            Spacer(modifier = Modifier.padding(32.dp))
            Button(
                onClick = { },
                shape = MaterialTheme.shapes.medium, modifier = Modifier
                    .height(72.dp)
                    .fillMaxWidth()) {
                Text(text = "SIGN UP", style = MaterialTheme.typography.button)
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Button(
                onClick = { navigationViewModel.goto(LOGIN_SCREEN) },
                colors = buttonColors(MaterialTheme.colors.secondary),
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .height(72.dp)
                    .fillMaxWidth()) {
                Text(text = "LOG IN", style = MaterialTheme.typography.button)
            }
        }
    }
}


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        WelcomeScreen(NavigationViewModel(rememberNavController()) )
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true){
        WelcomeScreen(NavigationViewModel(rememberNavController()))
    }
}