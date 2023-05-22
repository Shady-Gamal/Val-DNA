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

@Composable
fun BuddiesScreen(
    navController: NavController,
    viewModel: BuddiesViewModel = hiltViewModel(),
) {
    val buddiesState = viewModel.buddiesState
        LazyVerticalGrid(columns = GridCells.Adaptive(100.dp), content ={
            items(
                buddiesState.buddiesInfo?.size ?: 0
            ){

                SubcomposeAsyncImage(
                    model = buddiesState.buddiesInfo?.get(it)?.displayIcon,
                    loading = {
                        CircularProgressIndicator()
                    },
                    contentDescription = null
                )



            }
        } )

}