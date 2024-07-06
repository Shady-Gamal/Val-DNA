package com.example.valorant.main_activity.components

import com.example.valorant.R
import com.example.valorant.navigation.Screen


data class BottomNavigationItem(
    val id: String,
    val title: String,
    val icon : Int,

)

val bottomNavigationItemList : List<BottomNavigationItem> = listOf(
    BottomNavigationItem(Screen.HomeScreen.route ,"Home", R.drawable.home_filled),
    BottomNavigationItem(Screen.AgentScreen.route ,"A", R.drawable.agents),
    BottomNavigationItem(Screen.WeaponsScreen.route ,"Weapons", R.drawable.guns),
    BottomNavigationItem(Screen.BundlesScreen.route ,"Bundles", R.drawable.bundles_icon)
)

