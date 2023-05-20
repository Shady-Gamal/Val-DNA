package com.example.valorant.ui.agentDetails_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun AgentsInfoScreen(
    navController: NavController,

    viewModel: AgentDetailsViewModel = hiltViewModel()
) {

    val selectedAgentState = viewModel.selectedAgentState

    Box(modifier = Modifier.fillMaxSize()) {

        Text(text = selectedAgentState.selectedAgentDetails?.description ?: "error",
            modifier = Modifier.align(Alignment.Center))
    }
}