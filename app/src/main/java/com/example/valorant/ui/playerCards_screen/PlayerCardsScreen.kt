package com.example.valorant.ui.playerCards_screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.valorant.ui.home_screen.components.PlayerCardsLazyGrind
import com.example.valorant.ui.playerCards_screen.components.PlayerCardsLazyHorizontalGrid

@Composable
fun PlayerCardsScreen(
    navController: NavController,
    viewModel: PlayerCardsViewModel = hiltViewModel()
) {
    val playerCardsState = viewModel.playerCardsState


    PlayerCardsLazyHorizontalGrid(playerCardsState = playerCardsState)
}