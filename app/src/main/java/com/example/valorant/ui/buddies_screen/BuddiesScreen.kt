package com.example.valorant.ui.buddies_screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import com.example.valorant.ui.buddies_screen.components.BuddiesLazyGrid
import com.example.valorant.ui.sprays_screen.components.SpraysLazyGrid
import com.example.valorant.ui.theme.RedPrimary

@Composable
fun BuddiesScreen(
    navController: NavController,
    viewModel: BuddiesViewModel = hiltViewModel(),
) {
    val buddiesState = viewModel.buddiesState

    Box(Modifier.fillMaxSize()) {
        buddiesState.buddiesInfo?.let {
            BuddiesLazyGrid(buddiesState = buddiesState)
        }
        if (buddiesState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center), color = RedPrimary)
        }
    }
}