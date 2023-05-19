package com.example.valorant.ui.home_screen.components


import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.example.valorant.R
import com.example.valorant.ui.home_screen.HomeState
import com.example.valorant.ui.theme.RedPrimary
import com.example.valorant.ui.theme.WhiteForBodyText
import com.example.valorant.ui.theme.WhiteForTitleText
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ViewPager(
    modifier: Modifier = Modifier,
    state: HomeState,
){


    Card(shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(10.dp)

    ) {
        if (!(state.agentsInfo.isNullOrEmpty())){
        Box(modifier = Modifier.background(color = RedPrimary)) {
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
                                text = state.agentsInfo?.get(page)?.displayName ?: "Error",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = WhiteForTitleText
                            )
                            Spacer(modifier = modifier.width(4.dp))
                            Text(
                                text = state.agentsInfo?.get(page)?.role?.displayName
                                    ?: "Baiter", color = WhiteForTitleText
                            )
                        }
                        Text(
                            text = (state.agentsInfo?.get(page)?.description?.substring(
                                0,
                                50
                            ) + "...") ?: "oopsie",
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
                        AsyncImage(
                            model = state.agentsInfo?.get(page)?.background,
                            contentDescription = null,
                            modifier = Modifier
                                .align(
                                    Alignment.TopEnd
                                )

                                .fillMaxSize()
                                .scale(1f, 1.5f),
                            contentScale = ContentScale.FillBounds


                        )

                        AsyncImage(
                            model = state.agentsInfo?.get(page)?.fullPortrait,
                            contentDescription = null,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .scale(2f)
                                .offset(0.dp, 30.dp),
                            contentScale = ContentScale.FillHeight
                        )

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
        else{
            CircularProgressIndicator()
        }

    }}




