package com.example.valorant.main_activity.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.valorant.Constants
import com.example.valorant.navigation.Screen
import com.example.valorant.ui.theme.RedPrimary

@Composable
fun BottomNavigationBar(navController: NavController) {

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    NavigationBar(containerColor = if (currentDestination?.hierarchy?.any { it.route?.startsWith(Screen.AgentDetailsScreen.route) ?: false  } == true)
    {
        Color.Transparent

    }else {
        Color.White
    }
        , modifier = Modifier.height(Constants.Bottom_Nav_Bar_Height)) {


        bottomNavigationItemList.forEachIndexed { index, item ->
            NavigationBarItem(selected = currentDestination?.hierarchy?.any { it.route == item.id } == true

                , onClick ={
                selectedItemIndex = index
                navController.navigate(item.id) {
                    popUpTo(navController.graph.findStartDestination().id){ saveState = true}
                    launchSingleTop = true
                }

                                                                               }, icon = {
                Icon (painter = painterResource(id = item.icon), contentDescription = item.title)

            }, label = {
                Text(text = item.title)
            }, colors = NavigationBarItemDefaults.colors(indicatorColor = Color.White, selectedIconColor = RedPrimary, selectedTextColor = RedPrimary,
                    unselectedIconColor = if (currentDestination?.hierarchy?.any { it.route?.startsWith(Screen.AgentDetailsScreen.route) ?: false  } == true){
                            Color.White
                        }else{
                            Color.Gray
                        },

                    unselectedTextColor = if (currentDestination?.hierarchy?.any { it.route?.startsWith(Screen.AgentDetailsScreen.route) ?: false  } == true){
                        Color.White
                    }else{
                        Color.Gray
                    }))



        }
    }
    }

