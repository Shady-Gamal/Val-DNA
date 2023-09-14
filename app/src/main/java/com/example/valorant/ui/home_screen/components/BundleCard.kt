package com.example.valorant.ui.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.example.valorant.ui.home_screen.HomeState
import com.example.valorant.ui.theme.PinkForLazyRows
import com.example.valorant.ui.theme.RedPrimary
import com.example.valorant.ui.theme.RedSecondary

@Composable
fun BundleCard( homeState: HomeState,
  onITemClick : () -> Unit) {

    Card(shape = RoundedCornerShape(20.dp), modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .heightIn(185.dp)
        .clickable {
            onITemClick()
        }) {

        Box(Modifier.fillMaxSize()
            .heightIn(185.dp)
            .background(PinkForLazyRows)) {
            homeState.bundlesInfo?.let {
                SubcomposeAsyncImage(model = homeState.bundlesInfo?.get(0)?.displayIcon,
                    contentDescription = null,
                    loading = {
                        Box(modifier = Modifier.fillMaxWidth()) {
                            CircularProgressIndicator(color = RedPrimary)
                        } })
                Text(
                    text = homeState.bundlesInfo?.get(0)?.displayName ?: "Error", fontSize = 20.sp,
                    color = Color.White, modifier = Modifier
                        .padding(7.dp)
                        .background(
                            Color.Black.copy(.5f),
                            shape = CircleShape
                        )
                        .padding(10.dp)
                )
            }
            if (homeState.bundlesInfo.isNullOrEmpty()){
                CircularProgressIndicator(modifier = Modifier.align(Center))
            }


        }
    }

    }
