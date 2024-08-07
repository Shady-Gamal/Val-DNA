package com.example.valorant.main_activity.components

import com.example.valorant.R
import com.example.valorant.navigation.Screen

data class MenuItem(
    val id : String,
    val title : String,
    val icon : Int
)

val navigationList : List<MenuItem> = listOf(MenuItem(Screen.HomeScreen.route, "Home", R.drawable.home_filled),
    MenuItem(Screen.AgentScreen.route,"A", R.drawable.agents),
    MenuItem(Screen.MapsScreen.route,"Maps", R.drawable.maps),
    MenuItem(Screen.WeaponsScreen.route ,"Weapons", R.drawable.guns),
    MenuItem(Screen.BundlesScreen.route,"Bundles", R.drawable.bundles_icon),
    MenuItem(Screen.SpraysScreen.route,"Sprays", R.drawable.spray_icon),
    MenuItem(Screen.PlayerCardsScreen.route,"Player Cards", R.drawable.playercards_logo),
    MenuItem(Screen.BuddiesScreen.route,"Gun Buddies", R.drawable.gun_buddies)
)
