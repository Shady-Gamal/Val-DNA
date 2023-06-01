package com.example.valorant.ui.home_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.example.valorant.ui.home_screen.HomeState
import com.example.valorant.ui.theme.RedPrimary

@Composable
fun PlayerCardsLazyGrind(
    homeState: HomeState,
    onItemClick : () -> Unit
) {

    Column(modifier = Modifier.padding(10.dp)) {

        Text(text = "PlayerCards", fontSize = 25.sp,
            color = RedPrimary,
            fontWeight = FontWeight.Bold
            , modifier = Modifier.padding(bottom = 5.dp))

    LazyHorizontalGrid(rows = GridCells.Fixed(2), modifier = Modifier.height(200.dp), content ={


        items(homeState.playerCardsInfo?.size ?: 0){


            SubcomposeAsyncImage(model = homeState.playerCardsInfo?.get(it)?.wideArt, contentDescription = null,
            modifier = Modifier
                .padding(end = 10.dp, bottom = 10.dp)
                .clip(shape = CircleShape)
                .width(200.dp)
                .clickable {
                    onItemClick()
                }
               ,
            contentScale = ContentScale.FillHeight,
            loading = {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            })
        }
    } )}

}