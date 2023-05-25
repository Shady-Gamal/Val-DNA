package com.example.valorant.ui.maps_screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.valorant.ui.theme.RedPrimary

@Composable
fun MapsScreen(
    navController: NavController,
    viewModel: MapsViewModel = hiltViewModel()
) {


    val mapsState = viewModel.mapsState

    Log.e("tag4", mapsState.isLoading.toString() )
    Log.e("tag4", mapsState.mapsInfo?.size.toString() )





    var selectedMap by remember {
        mutableStateOf(0)
    }

if(!(mapsState.mapsInfo.isNullOrEmpty())) {
    Row(Modifier.fillMaxSize()) {


        Column(
            Modifier
                .padding(5.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(RedPrimary),
        ) {
            mapsState.mapsInfo?.forEachIndexed { index, mapItemDTO ->
                Row(
                    verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                        .width(100.dp)

                        .fillMaxHeight()
                        .weight(1f)
                        .background(
                            if (index == selectedMap) {
                                Color.Black
                            } else {
                                RedPrimary
                            }
                        )
                ) {
                    Text(
                        text = mapsState.mapsInfo.get(index).displayName ?: "error",
                        modifier = Modifier
                            .clickable {
                                selectedMap = index
                            }


                            .weight(1f)
                            .padding(10.dp),
                        fontWeight = FontWeight.Bold,
                        color = Color.White,


                        )

                }

            }
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(end = 5.dp, top = 10.dp)
        ) {

            Text(
                text = mapsState.mapsInfo?.get(selectedMap)?.displayName ?: "error",
                fontSize = 40.sp, fontWeight = FontWeight.Bold, color = RedPrimary,
                modifier = Modifier.align(CenterHorizontally)
            )

            AsyncImage(
                model = mapsState.mapsInfo?.get(selectedMap)?.splash, contentDescription = null,
                modifier = Modifier.clip(RoundedCornerShape(10.dp))
            )

            Spacer(modifier = Modifier.height(20.dp))


            Text(text = "Mini-Map View", fontSize = 20.sp, color = RedPrimary)
            AsyncImage(
                model = mapsState.mapsInfo?.get(selectedMap)?.displayIcon,
                contentDescription = null,
            )


        }


    }
}
    else if (mapsState.isLoading){
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.size(100.dp))
        }


    }






}