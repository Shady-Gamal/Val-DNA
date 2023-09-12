package com.example.valorant.main_activity

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.valorant.*
import com.example.valorant.R
import com.example.valorant.main_activity.components.AppBar
import com.example.valorant.main_activity.components.navigationList
import com.example.valorant.navigation.Navigation
import com.example.valorant.navigation.Screen
import com.example.valorant.ui.theme.RedSecondary
import com.example.valorant.ui.theme.ValorantTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel : MainViewModel by viewModels()
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
installSplashScreen().apply {
    this.setKeepOnScreenCondition{
        viewModel.isLoading.value
    }
}

        setContent {
            ValorantTheme {
                val navController = rememberNavController()
                val drawerState = rememberDrawerState(DrawerValue.Closed)
                val scope = rememberCoroutineScope()


                val navBackStackEntry by navController.currentBackStackEntryAsState()

                val topBarState = rememberSaveable { (mutableStateOf(true)) }

                when (navBackStackEntry?.destination?.route) {


                    Screen.WeaponDetailsScreen.route + "/{weaponId}" -> {

                        topBarState.value = false
                    }

                    Screen.AgentDetailsScreen.route + "/{agentId}" -> {
                        topBarState.value = false
                    }
                    Screen.WeaponSkinsScreen.route + "/{weaponId}" -> {

                        topBarState.value = false
                    }
                    else -> topBarState.value = true
                }



                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent ={
                        Column(modifier = Modifier
                            .width(200.dp)
                            .fillMaxSize()
                            .paint(
                                painter = painterResource(id = R.drawable.navigation_drawer_background),
                                contentScale = ContentScale.FillBounds
                            )){
                            drawerHeader()
                            drawerBody(items =
                       navigationList,
                                onItemClick = {navController.navigate(route = it.id){
                                    popUpTo(Screen.HomeScreen.route)
                                    launchSingleTop = true
                                }
                                scope.launch { drawerState.close() }
                                }
                            )
                        }
                }, content = {
                        Scaffold(
                            topBar = {
                                AnimatedVisibility(
                                    visible = topBarState.value,
                                    enter = slideInVertically(initialOffsetY = { -it }),
                                    exit = slideOutVertically(targetOffsetY = { -it }),
                                    content = {
                                        AppBar(onNavigationIconClick = {
                                            scope.launch { drawerState.apply { if (drawerState.isClosed) open() else close() } }

                                        }
                                        )
                                    }
                                )
                                     }, content = {
                            Box(modifier = Modifier
                                .padding(
                                    if (topBarState.value) it else {
                                        PaddingValues(0.dp)
                                    }
                                )
                                .background(RedSecondary)){
                            Navigation(navController = navController)

                            }
                        }
                        )
                }
                )
            }
        }
    }





}

