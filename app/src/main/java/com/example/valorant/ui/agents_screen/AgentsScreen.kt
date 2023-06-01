package com.example.valorant.ui.agents_screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.valorant.navigation.Screen
import com.example.valorant.ui.agents_screen.components.AgentsLazyGrid

@Composable
fun AgentsScreen(
    navController: NavController,
    viewModel: AgentsViewModel = hiltViewModel()
) {

    val agentsState = viewModel.agentsState

    AgentsLazyGrid(agentsState = agentsState,
    onItemClick = {
        navController.navigate(route = Screen.AgentDetailsScreen.route + "/${it.uuid}")
    }
        )
}