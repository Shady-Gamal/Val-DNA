package com.example.valorant.ui.bundles_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import com.example.valorant.ui.theme.RedPrimary
import kotlinx.coroutines.launch

@Composable
fun BundlesScreen(
    navController: NavController,
    viewModel: BundlesViewModel = hiltViewModel()
) {
    val bundlesState = viewModel.bundlesState

    val gradientBrush = Brush.horizontalGradient(
        colors = listOf(Color.Black, Color.Transparent),
        startX = 300f,
        endX = 450f
    )
    Box(modifier = Modifier.fillMaxSize()){

        if(!(bundlesState.bundlesInfo.isNullOrEmpty())) {
            val columnState = rememberLazyListState()
            val coroutineScope = rememberCoroutineScope()

            LazyColumn(state = columnState,content = {
                items(viewModel.itemCount) {
                    Card(modifier = Modifier.padding(10.dp)) {
                        Box(Modifier.fillMaxSize()) {


                            SubcomposeAsyncImage(
                                model = bundlesState.bundlesInfo.get(viewModel.getItemByIndex(it)).displayIcon,
                                contentDescription = null,
                                loading = {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(200.dp)
                                    ) {
                                        CircularProgressIndicator(
                                            modifier = Modifier.align(
                                                Alignment.Center
                                            )
                                        )
                                    }
                                }
                            )
                            Text(
                                text = bundlesState.bundlesInfo.get(viewModel.getItemByIndex(it)).displayName
                                    ?: "error", Modifier
                                    .align(Alignment.BottomStart)
                                    .fillMaxWidth()
                                    .background(brush = gradientBrush)
                                    .padding(8.dp),
                                color = Color.White)

                        }
                    }
                }
                item {

                    Row(horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()) {

                        if (viewModel.pageNumb > 0) {
                            Button(onClick = {
                                viewModel.pageNumb--
                                viewModel.calculateSizeOfPage()
                                coroutineScope.launch {
                                    columnState.animateScrollToItem(0)
                                }
                            }, content = {
                                Text(text = "Previous Page")
                            }
                                ,colors = ButtonDefaults.buttonColors(containerColor = RedPrimary)
                            )
                        }
                        if (viewModel.pageNumb < viewModel.calculateLastPageIndex()) {
                            Button(onClick = {
                               viewModel.pageNumb++
                                viewModel.calculateSizeOfPage()
                                coroutineScope.launch {
                                    columnState.animateScrollToItem(0)
                                }
                            }, content = {
                                Text(text = "Next Page")
                            }, colors = ButtonDefaults.buttonColors(containerColor = RedPrimary)

                            )
                        }

                        }
                    }


            })

        }
    }
}