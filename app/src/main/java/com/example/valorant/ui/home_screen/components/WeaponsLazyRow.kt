package com.example.valorant.ui.home_screen.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.example.domain.entities.AgentItemDTO
import com.example.domain.entities.WeaponItemDTO
import com.example.valorant.ui.home_screen.HomeState
import com.example.valorant.ui.theme.PinkForLazyRows
import com.example.valorant.ui.theme.RedPrimary
import com.example.valorant.R
import kotlin.math.ceil

@Composable
fun WeaponsLazyRow(state : HomeState,
onWeaponClick: (WeaponItemDTO) -> Unit,
onSeeMoreClick : () -> Unit) {

    Column(modifier = Modifier.padding(10.dp)) {


        Text(text = "Guns", fontSize = 25.sp,
        color = RedPrimary,
        fontWeight = FontWeight.Bold
        , modifier = Modifier.padding(bottom = 5.dp))
    
        LazyRow(){
        items(6){
            Card(modifier = Modifier
                .width(200.dp)
                .height(120.dp)
                .padding(end = 10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(color = PinkForLazyRows)
                        .fillMaxSize()
                        ) {
                        if(!(state.agentsInfo.isNullOrEmpty())){
                        if (it == 5) {

                            Box(modifier = Modifier
                                .fillMaxSize()
                                .clickable {
                                    onSeeMoreClick()
                                }) {
                                Text(
                                    text = "See More", modifier = Modifier
                                        .align(TopCenter)
                                        .padding(top = 5.dp)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.see_more_icon),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .align(Center)
                                        .size(60.dp)
                                )
                            }
                        } else {

                            Box(modifier = Modifier
                                .clickable
                                {
                                    onWeaponClick(state.weaponsInfo?.get(it)!!)
                                }
                                .fillMaxSize()) {
                                Text(
                                    text = state.weaponsInfo?.get(it)?.displayName ?: "Loading",
                                    modifier = Modifier
                                        .align(TopCenter)
                                        .padding(top = 5.dp)
                                )
                                Spacer(modifier = Modifier.height(10.dp))

                                SubcomposeAsyncImage(
                                    model = state.weaponsInfo?.get(it)?.displayIcon,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .align(Center)
                                        .sizeIn(maxWidth = 180.dp, maxHeight = 70.dp),
                                    loading = {
                                        Box(modifier = Modifier.fillMaxSize()){
                                            CircularProgressIndicator(modifier = Modifier.align(
                                                Center))
                                        }
                                    }

                                )
                            }
                        }
                    } else if (state.isLoading){
                        Box(modifier = Modifier.fillMaxSize()){

                            CircularProgressIndicator(modifier = Modifier.align(Center))
                        }

                    }


                    }
                }
            }


        }
    }
}