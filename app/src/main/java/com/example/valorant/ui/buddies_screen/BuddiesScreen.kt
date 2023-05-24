package com.example.valorant.ui.buddies_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import com.example.valorant.ui.buddies_screen.components.BuddiesLazyGrid
import com.example.valorant.ui.sprays_screen.components.SpraysLazyGrid

@Composable
fun BuddiesScreen(
    navController: NavController,
    viewModel: BuddiesViewModel = hiltViewModel(),
) {
    val buddiesState = viewModel.buddiesState
        BuddiesLazyGrid(buddiesState = buddiesState)

}