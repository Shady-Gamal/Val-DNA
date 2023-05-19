package com.example.valorant.ui.weapons_Screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.valorant.ui.weapons_Screen.components.WeaponsLazyGrid

@Composable
fun WeaponsScreen(
    navController: NavController,
    viewModel: WeaponsViewModel = hiltViewModel()
) {

 val weaponState = viewModel.weaponState
    
    WeaponsLazyGrid(weaponState = weaponState)


}