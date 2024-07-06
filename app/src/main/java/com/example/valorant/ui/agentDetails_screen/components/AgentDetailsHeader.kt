package com.example.valorant.ui.agentDetails_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.valorant.ui.agentDetails_screen.AgentDetailsState

@Composable
fun AgentDetailsHeader(agentDetailsState: AgentDetailsState,
modifier: Modifier = Modifier.height(300.dp)) {

    if (!(agentDetailsState.selectedAgentDetails?.background.isNullOrEmpty()))
        {
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(
                            android.graphics.Color.parseColor(
                                "#" + agentDetailsState.selectedAgentDetails?.backgroundGradientColors
                                    ?.get(0)
                                    ?.substring(0, 6)
                            )
                        ),
                        Color(
                            android.graphics.Color.parseColor(
                                "#" + agentDetailsState.selectedAgentDetails?.backgroundGradientColors
                                    ?.get(1)
                                    ?.substring(0, 6)
                            )
                        )
                    ),
                ),
            )
            .background(Color.Black.copy(alpha = .5f))) {
            Spacer(modifier=Modifier.height(WindowInsets.statusBars.asPaddingValues().calculateTopPadding()))
            Row{
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(10.dp)
                        .weight(1f)
                ) {
                    Text(
                        text = agentDetailsState.selectedAgentDetails?.displayName ?: "error",
                        fontSize = 40.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = agentDetailsState.selectedAgentDetails?.role?.displayName ?: "error",
                        fontSize = 20.sp,
                        modifier = Modifier,
                        color = Color.White,
                    )
                    Text(text = agentDetailsState.selectedAgentDetails?.description ?: "error",
                        color = Color.White,
                        modifier = Modifier
                            .padding(vertical = 5.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.Black.copy(alpha = .5f))
                            .padding(8.dp),
                        )
                }
                Box(modifier = Modifier
                    .clip(RoundedCornerShape(0.dp))
                    .weight(1f)) {
                    AsyncImage(
                        model = agentDetailsState.selectedAgentDetails?.background,
                        contentDescription = null,
                        modifier = Modifier

                            .offset(x = 30.dp)
                            .heightIn(max = 500.dp)
                            .wrapContentSize(),
                        contentScale = ContentScale.Crop
                    )
                    AsyncImage(
                        model = agentDetailsState.selectedAgentDetails?.fullPortrait,
                        contentDescription = null,
                        modifier = Modifier

                            .offset(y = 50.dp, x = 50.dp)
                            .heightIn(max = 500.dp)
                            .scale(1.5f)
                            .wrapContentSize(),
                        contentScale = ContentScale.Crop
                    )

                }

            }

        }


}}