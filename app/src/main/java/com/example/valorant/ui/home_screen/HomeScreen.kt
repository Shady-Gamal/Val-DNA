package com.example.valorant.ui.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.valorant.Screen
import com.example.valorant.ui.home_screen.components.*
import com.example.valorant.ui.theme.BackGround


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),

    ) {

    val state = viewModel.Homestate

    Column(modifier = Modifier.verticalScroll(rememberScrollState()).background(BackGround)) {
        AgentsViewPager(state = state, onItemClick = {
            navController.navigate(Screen.AgentScreen.route)
        })
        WeaponsLazyRow(state = state, onWeaponClick = {

            navController.navigate(Screen.WeaponDetailsScreen.route + "/${it.uuid}")
        },
        onSeeMoreClick = {
            navController.navigate(Screen.WeaponsScreen.route)
        })
        MapsViewPager(state = state, onItemClick = {
            navController.navigate(Screen.MapsScreen.route)
        })
        PlayerCardsLazyGrind(homeState = state, onItemClick = {
            navController.navigate(Screen.PlayerCardsScreen.route)
        })

        BundleCard(homeState = state, onITemClick = {
            navController.navigate(Screen.BundlesScreen.route)
        })
    }
}