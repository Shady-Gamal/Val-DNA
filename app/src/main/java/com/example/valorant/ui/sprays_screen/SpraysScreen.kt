package com.example.valorant.ui.sprays_screen

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun SpraysScreen(
    navController: NavController,
    viewModel: SpraysViewModel = hiltViewModel(),
) {

    val spraysState = viewModel.spraysState

    LazyRow(content = {
        items(spraysState.spraysInfo?.size ?: 0){

            AsyncImage(model = spraysState.spraysInfo?.get(it)?.displayIcon, contentDescription = null )
        }
    })

}