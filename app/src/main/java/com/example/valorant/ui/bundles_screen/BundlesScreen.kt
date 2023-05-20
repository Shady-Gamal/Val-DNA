package com.example.valorant.ui.bundles_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun BundlesScreen(
    navController: NavController,
    viewModel: BundlesViewModel = hiltViewModel()
) {

    val bundlesState = viewModel.bundlesState
    Box(modifier = Modifier.fillMaxSize()){

          LazyColumn(content = {

              items(bundlesState.bundlesInfo?.size ?: 0){

                  AsyncImage(model = bundlesState.bundlesInfo?.get(it)?.displayIcon, contentDescription =null )
                  Text(text = bundlesState.bundlesInfo?.get(it)?.displayName ?: "eroreta")
              }
          })
        }
}