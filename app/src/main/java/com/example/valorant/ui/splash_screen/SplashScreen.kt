package com.example.valorant.ui.splash_screen

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.valorant.R
import com.example.valorant.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {



    Box(
        Modifier
            .fillMaxSize()
            .paint(painterResource(id = R.drawable.navigation_drawer_background))) {

        Image(painter = painterResource(id = R.drawable.logo), contentDescription = null , modifier = Modifier.align(
            Alignment.Center))

    }


    LaunchedEffect(key1 = true){

        delay(1000)
        navController.navigate(Screen.HomeScreen.route)
    }


}