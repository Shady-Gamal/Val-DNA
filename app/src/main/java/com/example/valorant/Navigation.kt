package com.example.valorant

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.valorant.ui.agentDetails_screen.AgentsInfoScreen
import com.example.valorant.ui.agents_screen.AgentsScreen
import com.example.valorant.ui.buddies_screen.BuddiesScreen
import com.example.valorant.ui.bundles_screen.BundlesScreen
import com.example.valorant.ui.home_screen.HomeScreen
import com.example.valorant.ui.maps_screen.MapsScreen
import com.example.valorant.ui.playerCards_screen.PlayerCardsScreen
import com.example.valorant.ui.splash_screen.SplashScreen
import com.example.valorant.ui.sprays_screen.SpraysScreen
import com.example.valorant.ui.weaponDetails_screen.WeaponDetailsScreen
import com.example.valorant.ui.weapons_Screen.WeaponsScreen


@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.SplashScreen.route ){
        composable(route = Screen.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(route = Screen.HomeScreen.route){

            HomeScreen(navController = navController)
        }
        composable(route = Screen.AgentScreen.route){

            AgentsScreen(navController = navController)
        }
        composable(route = Screen.AgentDetailsScreen.route + "/{agentId}", arguments = listOf(
            navArgument("agentId"){
                type = NavType.StringType
            }
        )) {
           AgentsInfoScreen(navController = navController)
        }
        composable(route = Screen.WeaponsScreen.route){
            
            WeaponsScreen(navController = navController, )
        }

            composable(route = Screen.BundlesScreen.route){

                BundlesScreen(navController = navController)
            }

        composable(route = Screen.PlayerCardsScreen.route){

            PlayerCardsScreen(navController = navController)
        }
        composable(route = Screen.SpraysScreen.route){

            SpraysScreen(navController = navController)
        }
        composable(route = Screen.BuddiesScreen.route){

            BuddiesScreen(navController = navController)
        }
        composable(route = Screen.MapsScreen.route){

            MapsScreen(navController = navController)
        }
        composable(route = Screen.WeaponDetailsScreen.route + "/{weaponId}", arguments =
        listOf(
            navArgument("weaponId"){
                type = NavType.StringType
            }
        )
        ){
            
            WeaponDetailsScreen(navController = navController)
        }


    }


}