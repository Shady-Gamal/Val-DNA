package com.example.valorant
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.valorant.ui.theme.BackGround
import com.example.valorant.ui.theme.ValorantTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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


                var showBottomBar by rememberSaveable {
                    mutableStateOf(true)
                }


                val navBackStackEntry by navController.currentBackStackEntryAsState()


                showBottomBar = when (navBackStackEntry?.destination?.route) {
                    Screen.WeaponDetailsScreen.route + "/{weaponId}" -> false
                    Screen.AgentDetailsScreen.route + "/{agentId}" -> false
                    else -> true
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
                            )}
                }, content = {
                        Scaffold(
                            topBar = {
                                Log.e("agt",showBottomBar.toString())
                                if (showBottomBar) {AppBar(onNavigationIconClick = {
                                    scope.launch { drawerState.apply { if (drawerState.isClosed) open() else close() } }

                            }) }
                        }, content = {
                            Box(modifier = Modifier
                                .padding(it)
                                .background(BackGround)){
                            Navigation(navController = navController)

                            }
                        })



                    }
                )


            }
        }
    }
}

