package com.example.valorant.ui.weapons_Screen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.valorant.navigation.Screen
import com.example.valorant.ui.weapons_Screen.components.WeaponsLazyGrid

@Composable
fun WeaponsScreen(
    navController: NavController,
    viewModel: WeaponsViewModel = hiltViewModel()
) {

    val weaponState = viewModel.weaponState

        WeaponsLazyGrid(weaponState = weaponState,
    onItemClick = {
        navController.navigate(Screen.WeaponDetailsScreen.route + "/${it.uuid}")
    })



}