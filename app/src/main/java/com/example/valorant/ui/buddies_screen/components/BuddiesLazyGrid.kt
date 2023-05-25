package com.example.valorant.ui.buddies_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.example.data.model.BuddiesResponse
import com.example.valorant.ui.buddies_screen.BuddiesState
import com.example.valorant.ui.sprays_screen.SpraysState
import com.example.valorant.ui.theme.RedPrimary

@Composable
fun BuddiesLazyGrid (buddiesState : BuddiesState) {
    var viewImage by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize()
    ) {





        Card(modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = RedPrimary
            )
        ) {


            AsyncImage(
                model = buddiesState.buddiesInfo?.get(viewImage)?.displayIcon,
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .background(color = RedPrimary)
            )
        }

        if (!(buddiesState.buddiesInfo.isNullOrEmpty())){
            LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 100.dp), modifier = Modifier.fillMaxSize(), content ={

                items(buddiesState.buddiesInfo.size ?: 0){

                    SubcomposeAsyncImage(
                        model = buddiesState.buddiesInfo.get(it).displayIcon, contentDescription = null, loading = {
                            CircularProgressIndicator()
                        },
                        modifier = Modifier
                            .clickable {
                                viewImage = it
                            }
                            .size(100.dp)
                            .weight(1f)
                            .padding(10.dp)
                            .clip(shape = CircleShape)
                            .border(
                                width = 5.dp,
                                shape = CircleShape,
                                color = RedPrimary
                            )
                    )
                }
            } )
        }}
}