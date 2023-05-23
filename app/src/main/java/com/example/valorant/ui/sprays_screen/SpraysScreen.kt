package com.example.valorant.ui.sprays_screen

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.valorant.ui.sprays_screen.components.SpraysLazyGrid
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.currentCoroutineContext
import javax.inject.Inject

@Composable
fun SpraysScreen(
    navController: NavController,
    viewModel: SpraysViewModel = hiltViewModel(),
) {

    val spraysState = viewModel.spraysState

SpraysLazyGrid(spraysState = spraysState)

    }

