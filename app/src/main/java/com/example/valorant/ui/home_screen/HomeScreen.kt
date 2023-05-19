package com.example.valorant.ui.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.valorant.ui.home_screen.components.ViewPager
import com.example.valorant.ui.home_screen.components.WeaponsLazyRow
import com.example.valorant.ui.home_screen.components.MapsViewPager


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),

    ) {

    val state = viewModel.state

    Column {
        ViewPager(state = state)
        WeaponsLazyRow(state = state)
        MapsViewPager(state = state)
    }
}