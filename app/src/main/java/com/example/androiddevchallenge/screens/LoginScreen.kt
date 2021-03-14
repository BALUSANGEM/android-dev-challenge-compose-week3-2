package com.example.androiddevchallenge.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.HOME_SCREEN
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.viewmodel.NavigationViewModel
import com.example.androiddevchallenge.viewmodel.SoothViewModel

@Composable
fun LoginScreen(
    navigationViewModel: NavigationViewModel,
) {    val backgroundResource =
        if (isSystemInDarkTheme()){
            R.drawable.ic_dark_login
        } else {
            R.drawable.ic_light_login
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
        ){

            Text(
                text = "LOG IN",
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onBackground
            )

            Spacer(modifier = Modifier.padding(32.dp))

            TextField(
                modifier = Modifier.padding(start = 24.dp, end = 24.dp).height(56.dp).fillMaxWidth(),
                value = "",
                onValueChange = {  },
                label = {
                    Text("Email address")
                        },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.padding(8.dp))

            TextField(
                modifier = Modifier.padding(start = 24.dp, end = 24.dp).height(56.dp).fillMaxWidth(),
                value = "",
                onValueChange = {  },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(modifier = Modifier.padding(8.dp))

            Button(
                modifier = Modifier.padding(start = 24.dp, end = 24.dp).height(72.dp).fillMaxWidth(),
                onClick = { navigationViewModel.goto(HOME_SCREEN) },
                shape = MaterialTheme.shapes.medium,
            ) {
                Text(text = "LOG IN ", style = MaterialTheme.typography.button)
            }

            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}


@Preview("Light Theme LoginScreen", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewLoginScreen() {
    MyTheme {
        LoginScreen(NavigationViewModel(rememberNavController()))
    }
}

@Preview("Dark Theme LoginScreen", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewLoginScreen() {
    MyTheme(darkTheme = true){
        LoginScreen(NavigationViewModel(rememberNavController()))
    }
}