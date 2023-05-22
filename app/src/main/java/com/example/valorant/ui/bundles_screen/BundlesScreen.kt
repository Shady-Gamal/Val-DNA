package com.example.valorant.ui.bundles_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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

        if(!(bundlesState.bundlesInfo.isNullOrEmpty())) {
            var pageNumb by remember { mutableStateOf(0) }
            val itemCount = 5
            val lastPage = (bundlesState.bundlesInfo.size?.div(itemCount))?.minus(1)


            LazyColumn(content = {
                items(if(pageNumb < lastPage!!) itemCount else bundlesState.bundlesInfo.size % itemCount) {
                    AsyncImage(
                        model = bundlesState.bundlesInfo.get((it + (pageNumb * itemCount))).displayIcon,
                        contentDescription = null
                    )
                    Text(
                        text = bundlesState.bundlesInfo.get((it +(pageNumb * itemCount))).displayName
                            ?: "eroreta"
                    )
                }
            })
            if (!(bundlesState.bundlesInfo.isNullOrEmpty())) {
                if (pageNumb < ((bundlesState.bundlesInfo.size.div(itemCount)) - 1)) {
                    Button(onClick = {
                        pageNumb++
                    }, content = {
                        Text(text = "Next Page")

                    }


                    )
                }
            }
        }
    }
}