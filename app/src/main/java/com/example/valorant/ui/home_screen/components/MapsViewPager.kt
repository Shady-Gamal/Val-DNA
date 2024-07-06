package com.example.valorant.ui.home_screen.components


import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.example.valorant.R
import com.example.valorant.ui.home_screen.HomeState
import com.example.valorant.ui.theme.PinkForLazyRows
import com.example.valorant.ui.theme.RedPrimary
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MapsViewPager(
    modifier: Modifier = Modifier,
    state: HomeState,
    onItemClick : () -> Unit
) {
    Column(modifier = Modifier.padding(10.dp)) {
        val pageCount = state.mapsInfo?.size ?: 1
        val pagerState = rememberPagerState(
            initialPage = 0,
            initialPageOffsetFraction = 0f
        ) {
            pageCount
        }
        Text(
            text = "Maps", fontSize = 25.sp,
            color = RedPrimary,
            fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 5.dp)
        )

        Card(
            shape = RoundedCornerShape(10.dp),
        ) {
            Column(modifier = Modifier
                .background(color = PinkForLazyRows)
                .clickable {
                    onItemClick()
                }) {

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
                    Box {
                        val gradientBrush = Brush.horizontalGradient(
                            colors = listOf(Color.Black.copy(.7f), Color.Transparent),
                            startX = 300f, endX = 600f

                        )

                        if (!(state.mapsInfo.isNullOrEmpty())) {

                            SubcomposeAsyncImage(
                                model = state.mapsInfo.get(page).splash,
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                loading = {
                                    Box(modifier = Modifier.fillMaxSize()) {

                                        CircularProgressIndicator(modifier = Modifier.align(Center))
                                    }
                                }
                            )
                            Column(
                                modifier = Modifier
                                    .background(brush = gradientBrush)
                                    .fillMaxWidth(0.5f)
                                    .fillMaxHeight()
                                    .padding(10.dp)

                                    ,


                            ) {


                                    Text(
                                        text = state.mapsInfo?.get(page)?.displayName ?: "error",
                                        color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = state.mapsInfo?.get(page)?.narrativeDescription
                                            ?: "Description isn't available yet",
                                        fontSize = 17.sp,
                                        color = Color.White,
                                        modifier = Modifier.weight(.7f)
                                        , overflow = TextOverflow.Ellipsis


                                    )

                                Image(
                                    painter = painterResource(id = R.drawable.learnmore_viewpager),
                                    contentDescription = "learn more",
                                    contentScale = ContentScale.None,
                                    modifier = Modifier.padding(10.dp)

                                )
                            }
                        } else if (state.isLoading) {
                            Box(modifier = Modifier.fillMaxSize()) {
                                CircularProgressIndicator(modifier = Modifier.align(Center))
                            }
                        }
                    }
                }

            }


        }


        Row(
            Modifier
                .fillMaxWidth()
                .align(CenterHorizontally)
            ,
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration)  Color.Red else  Color.White
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

