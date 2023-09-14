package com.example.valorant.ui.sprays_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.valorant.ui.sprays_screen.components.SpraysLazyGrid
import com.example.valorant.ui.theme.RedPrimary
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.currentCoroutineContext
import javax.inject.Inject

@Composable
fun SpraysScreen(
    navController: NavController,
    viewModel: SpraysViewModel = hiltViewModel(),
) {

    val spraysState = viewModel.spraysState

    Box(Modifier.fillMaxSize()) {

        spraysState.spraysInfo?.let {
            SpraysLazyGrid(spraysState = spraysState)
        }
        if (spraysState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = RedPrimary
            )
        }
    }
    }

