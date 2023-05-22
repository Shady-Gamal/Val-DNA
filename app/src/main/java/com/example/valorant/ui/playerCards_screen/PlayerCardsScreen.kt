package com.example.valorant.ui.playerCards_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun PlayerCardsScreen(
    navController: NavController,
    viewModel: PlayerCardsViewModel = hiltViewModel()
) {
    val playerCardsState = viewModel.playerCardsState
    LazyRow(content = {

        items(playerCardsState.playerCardsInfo?.size ?: 0){

            AsyncImage(model = playerCardsState.playerCardsInfo?.get(it)?.displayIcon, contentDescription = null)
        }
    })
}