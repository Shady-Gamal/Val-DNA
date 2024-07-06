package com.example.valorant.ui.agents_screen.components
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.example.domain.entities.AgentItemDTO
import com.example.valorant.ui.agents_screen.AgentsState


@Composable
fun AgentsLazyGrid(
    agentsState: AgentsState,
    onItemClick: (AgentItemDTO) -> Unit

) {
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        modifier = Modifier.testTag("A"), content = {

        items(agentsState.agentsInfo?.size ?: 0){

            Card(modifier = Modifier
                .padding(10.dp)
                .width(200.dp)
                .height(180.dp)
                .clickable {
                    onItemClick(agentsState.agentsInfo?.get(it)!!)
                }
            ,
            ) {
                Row(
                    modifier = Modifier
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color(
                                        android.graphics.Color.parseColor(
                                            "#" + agentsState.agentsInfo?.get(
                                                it
                                            )?.backgroundGradientColors
                                                ?.get(3)
                                                ?.substring(0, 6)
                                        )
                                    ),
                                    Color(
                                        android.graphics.Color.parseColor(
                                            "#" + agentsState.agentsInfo?.get(
                                                it
                                            )?.backgroundGradientColors
                                                ?.get(0)
                                                ?.substring(0, 6)
                                        )
                                    )
                                )
                            ),
                        )
                        .fillMaxSize()
                        .clip(RoundedCornerShape(0.dp))
                        .background(Color.Black.copy(.3f))

                ) {

                    Column(modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 5.dp),
                    verticalArrangement = Arrangement.Center) {
                        Text(text = agentsState.agentsInfo?.get(it)?.displayName ?: "Unknown" ,
                            modifier = Modifier
                                .padding(top = 5.dp),
                         color = Color.White,
                        fontWeight = FontWeight.Bold
                        )

                        Text(text = agentsState.agentsInfo?.get(it)?.role?.displayName ?: "Unknown" ,
                            modifier = Modifier
                                .padding( 5.dp),
                            color = Color.White)

                    }



                    SubcomposeAsyncImage(model = agentsState.agentsInfo?.get(it)?.fullPortrait, contentDescription = null
                        , modifier = Modifier
                            .scale(1.5f)
                            .offset(y = (30).dp)
                            ,
                        contentScale = ContentScale.FillHeight,
                        loading = {
                            Box(modifier = Modifier.fillMaxSize()) {
                                CircularProgressIndicator(modifier = Modifier.align(Center)
                                    .offset(y = (-30).dp))
                            }
                        }



                    )
                }
            }



        }


    })
}
