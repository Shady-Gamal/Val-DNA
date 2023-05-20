package com.example.valorant.ui.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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

    val state = viewModel.Homestate

    Column {
        ViewPager(state = state)
        WeaponsLazyRow(state = state)
        MapsViewPager(state = state)
    }
}