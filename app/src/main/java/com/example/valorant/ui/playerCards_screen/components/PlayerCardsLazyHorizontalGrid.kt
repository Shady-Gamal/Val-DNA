package com.example.valorant.ui.playerCards_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.valorant.ui.playerCards_screen.PlayerCardsState
import com.example.valorant.ui.theme.RedPrimary

@Composable
fun PlayerCardsLazyHorizontalGrid(playerCardsState : PlayerCardsState)
{

    LazyHorizontalGrid(rows = GridCells.Fixed(3), modifier = Modifier.fillMaxSize() , content = {

        items(playerCardsState.playerCardsInfo?.size ?:0){
            Box (){

            AsyncImage(model = playerCardsState.playerCardsInfo?.get(it)?.largeArt, contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .border(width = 4.dp, color = RedPrimary), contentScale = ContentScale.FillHeight)


            }

    }})
}