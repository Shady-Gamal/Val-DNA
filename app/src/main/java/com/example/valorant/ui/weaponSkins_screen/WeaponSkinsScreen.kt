package com.example.valorant.ui.weaponSkins_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import com.example.valorant.navigation.Screen

@Composable
fun WeaponSkinsScreen(
    navController: NavController,
    viewModel: WeaponSkinsViewModel = hiltViewModel(),
) {

    val weaponSkinsState = viewModel.weaponSkinsState

    LazyColumn(modifier = Modifier.fillMaxSize(), content ={

        items(weaponSkinsState.WeaponSkins?.skins?.size ?: 0){

            Card(modifier = Modifier.padding(10.dp)) {

            SubcomposeAsyncImage(model = weaponSkinsState.WeaponSkins?.skins?.get(it)?.displayIcon, contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),loading = {
                    Box(modifier = Modifier.fillMaxSize()) {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }
                }

            )
            }}
    } )

}