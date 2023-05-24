package com.example.valorant.ui.sprays_screen.components

import android.content.Context
import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.example.valorant.R
import com.example.valorant.ui.sprays_screen.SpraysState
import com.example.valorant.ui.theme.RedPrimary
import dagger.hilt.android.qualifiers.ApplicationContext


@Composable
fun SpraysLazyGrid(spraysState: SpraysState) {
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
                model = spraysState.spraysInfo?.get(viewImage)?.displayIcon,
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .fillMaxWidth()

                    .align(CenterHorizontally)
                    .background(color = RedPrimary)


            )
        }

    if (!(spraysState.spraysInfo.isNullOrEmpty())){
    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 100.dp), modifier = Modifier.fillMaxSize(), content ={

        items(spraysState.spraysInfo.size ?: 0){

            SubcomposeAsyncImage(
                    model = spraysState.spraysInfo.get(it)?.displayIcon, contentDescription = null, loading = {
                CircularProgressIndicator()},
                   modifier = Modifier
                       .clickable {
                           viewImage = it
                       }
                       .size(100.dp)
                       .weight(1f)
                       .padding(10.dp)
                       .clip(shape = CircleShape)
                       .border(width = 5.dp,
                       shape = CircleShape,
                       color = RedPrimary
                       )
            )
        }
    } )}}
}