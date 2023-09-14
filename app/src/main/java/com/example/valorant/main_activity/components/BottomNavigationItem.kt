package com.example.valorant.main_activity.components

import com.example.valorant.R
import com.example.valorant.navigation.Screen


data class BottomNavigationItem(
    val id: String,
    val title: String,
    val selectedIcon : Int,
    val unselectedIcon : Int

)

val bottomNavigationItemList : List<BottomNavigationItem> = listOf(
    BottomNavigationItem(Screen.HomeScreen.route ,"Home", R.drawable.home_filled, R.drawable.spray_icon),
    BottomNavigationItem(Screen.AgentScreen.route ,"Agents", R.drawable.agents, R.drawable.spray_icon),
    BottomNavigationItem(Screen.WeaponsScreen.route ,"Weapons", R.drawable.guns, R.drawable.spray_icon),
    BottomNavigationItem(Screen.BundlesScreen.route ,"Bundles", R.drawable.bundles_icon, R.drawable.spray_icon)
)

