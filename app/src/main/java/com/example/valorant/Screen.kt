package com.example.valorant

sealed class Screen(val route : String){
object HomeScreen : Screen("main_screen")
object AgentScreen : Screen("agents_screen")
    object AgentInfoScreen : Screen("agentInfo_screen")
    object WeaponsScreen : Screen("weapons_screen")



}
