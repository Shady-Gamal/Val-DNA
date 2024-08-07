package com.example.valorant.ui.home_screen.components


import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.example.valorant.R
import com.example.valorant.ui.home_screen.HomeState
import com.example.valorant.ui.theme.RedPrimary
import com.example.valorant.ui.theme.RedSecondary
import com.example.valorant.ui.theme.WhiteForBodyText
import com.example.valorant.ui.theme.WhiteForTitleText
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AgentsViewPager(
    modifier: Modifier = Modifier,
    state: HomeState,
    onItemClick : () -> Unit
){


    Card(shape = RoundedCornerShape(10.dp),
        modifier = modifier.padding(10.dp)

    ) {


        Box(modifier = Modifier.background(color = RedPrimary)
            .clickable {
                onItemClick()
            }) {
            val pageCount = 3
            val pagerState = rememberPagerState(
                initialPage = 0,
                initialPageOffsetFraction = 0f
            ) {
                pageCount
            }
            LaunchedEffect(Unit) {
                while (true) {
                    yield()
                    delay(2000)
                    pagerState.animateScrollToPage(
                        page = (pagerState.currentPage + 1) % (pageCount),
                        animationSpec = tween(600)
                    )
                }
            }


            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(185.dp)

            ) { page ->

                val shownAgent = page*6 + 4
                if(!(state.agentsInfo.isNullOrEmpty())) {
                    Row() {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 10.dp, top = 15.dp), Arrangement.Top
                        ) {
                            Row(
                                modifier = Modifier.align(Start),
                                verticalAlignment = Alignment.Bottom
                            ) {
                                Text(
                                    text = state.agentsInfo?.get(shownAgent)?.displayName
                                        ?: "Error",
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = WhiteForTitleText
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = state.agentsInfo?.get(shownAgent)?.role?.displayName
                                        ?: "Baiter", color = WhiteForTitleText
                                )
                            }
                            Text(
                                text = (state.agentsInfo?.get(shownAgent)?.description?.substring(
                                    0,
                                    50
                                ) + "...") ,
                                color = WhiteForBodyText,
                                fontSize = 15.sp
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            Image(
                                painter = painterResource(id = R.drawable.seemore_viewpager),
                                contentDescription = null,
                                modifier = Modifier.align(Start)
                            )
                        }
                        Box(
                            Modifier
                                .weight(1f)
                        )
                        {
                            SubcomposeAsyncImage(
                                model = state.agentsInfo?.get(shownAgent)?.background,
                                contentDescription = null,
                                modifier = Modifier
                                    .align(
                                        Alignment.TopEnd
                                    )

                                    .fillMaxSize()
                                    .scale(1f, 1.5f),
                                contentScale = ContentScale.FillBounds,
                                loading = {
                                    Box(modifier = Modifier
                                        .fillMaxSize()
                                      ){
                                        CircularProgressIndicator(modifier = Modifier.align(Center), color = Color.White)
                                    }
                                }



                            )

                            SubcomposeAsyncImage(
                                model = state.agentsInfo?.get(shownAgent)?.fullPortrait,
                                contentDescription = null,
                                modifier = Modifier
                                    .align(Alignment.TopEnd)
                                    .scale(2f)
                                    .offset(0.dp, 30.dp),
                                contentScale = ContentScale.FillHeight,
                                loading = {

                                    Box(modifier = Modifier
                                        .fillMaxSize()
                                        .offset(0.dp, (-30).dp),){
                                        CircularProgressIndicator(modifier = Modifier.align(Center), color = RedPrimary)
                                    }
                                }
                            )

                        }

                    }
                }else  if (state.isLoading){
                    Box(modifier = Modifier.fillMaxSize()) {
                        CircularProgressIndicator(modifier = Modifier.align(Center), color = Color.White )
                    }


                }
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .align(alignment = BottomCenter),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(pageCount) { iteration ->
                    val color =
                        if (pagerState.currentPage == iteration) Color.White else Color.Red
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(10.dp)
                    )
                }
            }

        }




    }


}




