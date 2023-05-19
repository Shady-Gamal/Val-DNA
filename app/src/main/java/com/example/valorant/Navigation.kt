package com.example.valorant

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.valorant.ui.AgentInfoScreen.AgentsInfoScreen
import com.example.valorant.ui.agents_screen.AgentsScreen
import com.example.valorant.ui.home_screen.HomeScreen
import com.example.valorant.ui.weapons_Screen.WeaponsScreen


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route ){
        composable(route = Screen.HomeScreen.route){

            HomeScreen(navController = navController)
        }
        composable(route = Screen.AgentScreen.route){

            AgentsScreen(navController = navController)
        }
        composable(route = Screen.AgentInfoScreen.route + "/{agentId}", arguments = listOf(
            navArgument("agentId"){
                type = NavType.StringType
            }
        )) {
           AgentsInfoScreen(navController = navController)
        }
        composable(route = Screen.WeaponsScreen.route){
            
            WeaponsScreen(navController = navController, )
        }
    }


}