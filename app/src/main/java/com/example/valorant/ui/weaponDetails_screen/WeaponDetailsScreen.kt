package com.example.valorant.ui.weaponDetails_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.valorant.navigation.Screen
import com.example.valorant.ui.theme.RedPrimary
import com.example.valorant.ui.weaponDetails_screen.components.WeaponStatsItem

@Composable
fun WeaponDetailsScreen(
    navController: NavController,
    viewModel: WeaponDetailsViewModel = hiltViewModel(),
) {

    val selectedWeaponDetailsState = viewModel.weaponDetailsState

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.size(WindowInsets.statusBars.asPaddingValues().calculateTopPadding()))

        Card(modifier = Modifier
            .align(CenterHorizontally)
            .height(200.dp)
            .fillMaxWidth()
            .padding(20.dp)) {
            Box(modifier = Modifier.fillMaxSize()
            , contentAlignment = Center) {
                AsyncImage(
                    model = selectedWeaponDetailsState.selectedWeaponDetails?.displayIcon,
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                        , modifier = Modifier.fillMaxSize()

                )
            }
        }
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            WeaponStatsItem(title = "Damage", value = selectedWeaponDetailsState.selectedWeaponDetails?.weaponStats?.damageRanges?.get(0)?.bodyDamage.toString())
            WeaponStatsItem(title = "FireRate", value = selectedWeaponDetailsState.selectedWeaponDetails?.weaponStats?.fireRate.toString())
            WeaponStatsItem(title = "Magazine Size", value = selectedWeaponDetailsState.selectedWeaponDetails?.weaponStats?.magazineSize.toString())
            WeaponStatsItem(title = "price", value = selectedWeaponDetailsState.selectedWeaponDetails?.shopData?.cost.toString())
        }

        Button(modifier = Modifier.align(CenterHorizontally)
            , onClick = { navController.navigate(Screen.WeaponSkinsScreen.route + "/${selectedWeaponDetailsState.selectedWeaponDetails?.uuid}") }
        , colors = ButtonDefaults.buttonColors(RedPrimary)){
            Text(text = "Check out the weapon's skins")

        }

    }
}