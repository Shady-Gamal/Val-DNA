package com.example.valorant.ui.bundles_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.magnifier
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
                    Card(modifier = Modifier.padding(10.dp)) {

                        AsyncImage(
                            model = bundlesState.bundlesInfo.get((it + (pageNumb * itemCount))).displayIcon,
                            contentDescription = null
                        )
                        Text(
                            text = bundlesState.bundlesInfo.get((it + (pageNumb * itemCount))).displayName
                                ?: "eroreta",Modifier.padding(5.dp)
                        )
                    }
                }
                item {

                    Row(horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()) {


                        if (pageNumb > 0) {
                            Button(onClick = {
                                pageNumb--
                            }, content = {
                                Text(text = "Previous Page")

                            }
                            )
                        }
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


            })

        }
    }
}