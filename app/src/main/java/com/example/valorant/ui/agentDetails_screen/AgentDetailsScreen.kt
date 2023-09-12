package com.example.valorant.ui.agentDetails_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.valorant.ui.agentDetails_screen.components.AgentDetailsBody
import com.example.valorant.ui.agentDetails_screen.components.AgentDetailsHeader

@Composable
fun AgentsInfoScreen(
    navController: NavController,

    viewModel: AgentDetailsViewModel = hiltViewModel()
) {

    val selectedAgentState = viewModel.agentDetailsState

    Column {


        AgentDetailsHeader(agentDetailsState = selectedAgentState)
        AgentDetailsBody(agentDetailsState = selectedAgentState)
    }
}