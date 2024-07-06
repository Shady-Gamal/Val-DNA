package com.example.valorant.ui.agentDetails_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.example.valorant.Constants
import com.example.valorant.R
import com.example.valorant.ui.agentDetails_screen.AgentDetailsState
import com.example.valorant.ui.theme.RedPrimary

@Composable
fun AgentDetailsBody(agentDetailsState: AgentDetailsState) {

    var selectedOption by remember {
        mutableStateOf(0)
    }
    val onSelectionChange = { text: Int ->
        selectedOption = text
    }

    if (!(agentDetailsState.selectedAgentDetails?.background.isNullOrEmpty()))
        {
            Column(
                modifier = Modifier
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
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = .5f))

            ) {

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()

                    ,
                ) {
                    agentDetailsState.selectedAgentDetails?.abilities?.forEachIndexed { index, item ->

                        SubcomposeAsyncImage(
                                model = item?.displayIcon , loading = {
                                  CircularProgressIndicator()
                                }, error = {
                                       Image(painter = painterResource(id = R.drawable.agents), contentDescription =null,
                                       modifier = Modifier.aspectRatio(ratio = 1f))
                                },
                                contentDescription = null,

                                modifier = Modifier
                                    .padding(all = 8.dp)
                                    .clip(
                                        shape = RoundedCornerShape(
                                            size = 12.dp,
                                        ),
                                    )
                                    .clickable {
                                        onSelectionChange(index)
                                    }
                                    .background(
                                        if (index == selectedOption) {
                                            RedPrimary
                                        } else {
                                            Color.LightGray
                                        }
                                    )
                                    .padding(
                                        vertical = 12.dp,
                                        horizontal = 16.dp,
                                    )
                                    .weight(1f),
                            )

                    }
                }
                Column(modifier = Modifier
                    .padding(10.dp)
                    .padding(bottom = Constants.Bottom_Nav_Bar_Height)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.Black.copy(alpha = .5f))
                    .verticalScroll(rememberScrollState())

                    .padding(10.dp)
                    ) {

                    Text(text = agentDetailsState.selectedAgentDetails?.abilities?.get(selectedOption)?.displayName ?: "error", color = Color.White,
                    fontWeight = FontWeight.Bold, fontSize = 22.sp
                    
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = agentDetailsState.selectedAgentDetails?.abilities?.get(selectedOption)?.description
                            ?: "nullnolla",
                        color = Color.White,

                    )
                }
            }
        }
}
val String.color
    get() = Color(android.graphics.Color.parseColor(this))