package com.wemoonyx.jetpackcomposecourse

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.wemoonyx.jetpackcomposecourse.model.Routes

@Composable
fun ScreenOne(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Text(text = "Screen One", modifier = Modifier.align(Alignment.Center).clickable {
            navController.navigate(Routes.ScreenTwo.route)
        })
    }
}

@Composable
fun ScreenTwo(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text(text = "Screen Two", modifier = Modifier.align(Alignment.Center).clickable {
            navController.navigate(Routes.ScreenThree.route)
        })
    }
}

@Composable
fun ScreenThree(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(text = "Screen Three", modifier = Modifier.align(Alignment.Center).clickable {
            navController.navigate("${Routes.ScreenFour.route}/David")
        })
    }
}

@Composable
fun ScreenFour(navController: NavHostController, name: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(text = name, modifier = Modifier.align(Alignment.Center).clickable {
            navController.navigate(Routes.ScreenOne.route)
        })
    }
}