package com.example.valorant.ui.home_screen.components


import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.R
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.valorant.ui.home_screen.HomeState
import com.example.valorant.ui.theme.RedPrimary
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MapsViewPager(
    modifier: Modifier = Modifier,
    state: HomeState,
    onItemClick : () -> Unit
){
Column(modifier = Modifier.padding(10.dp)) {

    Text(text = "Maps", fontSize = 25.sp,
        color = RedPrimary,
        fontWeight = FontWeight.Bold
        , modifier = Modifier.padding(bottom = 5.dp))

    Card(
        shape = RoundedCornerShape(10.dp),
    ) {
        Box(modifier = Modifier.background(color = RedPrimary).clickable {
            onItemClick()
        }) {
            val pageCount = state.mapsInfo?.size ?: 1
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
                Box() {

                    AsyncImage(
                        model = state.mapsInfo?.get(page)?.splash,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = state.mapsInfo?.get(page)?.displayName ?: "Error", fontSize = 40.sp,
                        color = Color.White, modifier= Modifier.padding(7.dp)
                            .background(Color.Black.copy(.5f),
                            shape = CircleShape
                        ).padding(10.dp)
                    )
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
}


